import React, {useState} from 'react'
import styled from 'styled-components';
import { useNavigate } from 'react-router-dom';
import Request from '../../helpers/request';

// const PageDiv = styled.div`
//     display: flex;
//     flex-direction: column;
//     justify-content: center;
// `

const Button = styled.button`
    background-color: yellow;
    height: 22px;
    width: 82.35px;
    font-size: 16px;
    text-align: center;
`

const StoryText = styled.h4`
    color: yellow;
    font-size:16px;
    text-align: center;
`

const Barnacles = styled.div`
    padding: 1em;
    display: flex;
    flex-direction: row;
    justify-content: center;
`

const Patches = styled.div`
    padding: 1em;
    display: flex;
    flex-direction: row;
    justify-content: center;
`

const TextDiv = styled.div`
    display: flex;
    flex-direction: column;
`

const BarnaclesText = styled.h4`
    color: orange;
    font-size:16px;
    text-align: center;
`

const PatchesText = styled.h4`
    color: pink;
    font-size:16px;
    text-align: center;
`

const BottomDiv = styled.div`
    padding: 1em;
    display: flex;
    flex-direction: row;
    gap: 1em;
    justify-content: center;
`
const HiddenDiv = styled.div`
    padding: 0.5em;
    display: flex;
    flex-direction: column;
    justify-content: center;
`

const StatText = styled.div`
    color: yellow;
    font-size:16px;
    text-align: center;
`

const East = ({ships, updateShip, updateShips, setEastVisited}) => {

    const [show, setShow] = useState(false);
    const [currentTurn, setCurrentTurn] = useState(0)
    const [hitMessage, setHitMessage] = useState("");
    const [endBattle, setEndBattle] = useState("");
    const navigate = useNavigate();
    const request = new Request();

    const backToSail = (event) => {
        navigate('/sail')

    }


    let seacleaver = ships.find(ship => ship.id === 1);
    let ursula = ships.find(ship => ship.id === 2);




    const fire = () => {
        console.log('fire called');
        if(ships[0].healthPoints > 0 && ships[1].healthPoints >0){

        let playerShip = {}
        let enemyShip = {}
        if(currentTurn === 0){
            playerShip = {...ships[0]}
            enemyShip = {...ships[1]}
        }else{
            playerShip = {...ships[1]}
            enemyShip = {...ships[0]}
        }

        let roll = (Math.floor(Math.random() * 20 - 1) + 1)
        console.log('roll', roll);
        let newShip = {...currentTurn}
        console.log('newship', newShip);
        
        let attack = playerShip.attkPoints;
        let armour = enemyShip.armour;
        if(roll >= armour){
            enemyShip.healthPoints -= attack
            setHitMessage(`${playerShip.name} hit ${enemyShip.name} for ${attack} damage!`)
        } else {
            setHitMessage(`${playerShip.name} missed!`)
        }

        let newShips = [playerShip, enemyShip]
        updateShips(newShips);

        if(currentTurn === 0){
            setCurrentTurn(1)
        }else{
            setCurrentTurn(0)
        }            
        } else {
            if(ships[0].healthPoints <= 0){
                setHitMessage("")
                setEndBattle("You go with The Seacleaver down to Davy Jones' locker...")
                
            } else if(ships[1].healthPoints <= 0){
                setHitMessage("")
                repair();
                setEndBattle("You watch Ursula's Revenge go down as your crew cheers in triumph! After the battle, you and the crew repair the ship.")
                setEastVisited(true);
            }
        }
        }
    
        const repair = () => {
            setEastVisited(true)
            const fixedShip = {
            name: "The Seacleaver",
            coffers: seacleaver.coffers,
            healthPoints: 200,
            armour: 16,
            attkPoints: 20,
            status: "SAILING"};
            request.put('/api/ships/' + seacleaver.id, fixedShip).then(data => data.json()).then(data => updateShip(data));
        }


    return(
        <>
        {!show ? (
            <>
            <StoryText>
                You sail East upon The Seacleaver. The weather seems to get greyer and foggier as you move forward. Eventually, you can barely see 10 feet from the Bowsprit. 
            </StoryText>
            <Patches>
                <PatchesText>
                    <strong>Patches: </strong>*SQUAWK!* Shiver me timbers!
                </PatchesText>
            </Patches>
            <StoryText>
                Suddenly, less than 100ft away, you hear people cheering and a loud <strong>BOOM!</strong> A cannonball flies past The Seacleaver's right side by a meter before splashing into the sea.
            </StoryText>
            <Barnacles>
                <BarnaclesText><strong>Barnacles: </strong>EVERYONE TO THE CANNONS!</BarnaclesText>
            </Barnacles>
            <StoryText>
                You finally see a large, black ship before you, its crew jeering and yelling as they gleefully reload their cannons. You have heard stories of a black ship attacking and plundering pirate ships called <em>Ursula's Revenge</em>.
            </StoryText>
            <BottomDiv>
                <Button onClick={() => setShow(true)}>FIGHT!</Button>
                <Button onClick={backToSail}>Escape</Button>
            </BottomDiv>
            </>

        ) : (<>
        <HiddenDiv>
            <TextDiv>
                <StoryText>Ursula's Revenge</StoryText>
                <StatText value={ursula.healthPoints}>HP: {ursula.healthPoints}</StatText>
                <Barnacles>
                    <BarnaclesText>
                    <strong>Barnacles: </strong>Ready to fire, Cap'n!
                    </BarnaclesText>
                </Barnacles>
                <StatText>
                <StoryText>{hitMessage}</StoryText>
                    <StoryText>{endBattle}</StoryText>
                </StatText>
            </TextDiv>
            <BottomDiv>
                <Button onClick={fire}>Fire!</Button>
                <Button onClick={backToSail}>Leave</Button>
            </BottomDiv>
        </HiddenDiv>
        </>    
        )}

        </>
    )

}

export default East;