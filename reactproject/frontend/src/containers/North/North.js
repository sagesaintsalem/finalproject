import React, {useState} from 'react'
import styled from 'styled-components';
import {useNavigate} from 'react-router-dom';
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
const SeagullDiv = styled.div`
    display: flex;
    flex-direction: row;
    justify-content: space-evenly;
`


const StatText = styled.div`
    color: yellow;
    font-size:16px;
    text-align: center;
`

const North = ({enemies, updateEnemy, npcs, updateNPC, player, setNorthVisited}) => {

    const [show, setShow] = useState(false);
    const [currentTurn, setCurrentTurn] = useState(0)
    const [hitMessage, setHitMessage] = useState("");
    const [endBattle, setEndBattle] = useState("");
    const [enemyKO, setEnemyKO] = useState(false);
    const navigate = useNavigate();
    // const request = new Request();

    const backToSail = (event) => {
        navigate('/sail')
    }

    
    const seagull1 = enemies.find(enemy => enemy.id === 1);
    const seagull2 = enemies.find(enemy => enemy.id === 2);
    const seagull3 = enemies.find(enemy => enemy.id === 3);
    const seagull4 = enemies.find(enemy => enemy.id === 4);

    

    const attack = () => {
        if(seagull1.healthPoints > 0 && seagull2.healthPoints > 0 &&seagull3.healthPoints > 0 &&seagull4.healthPoints > 0 ){
            setEnemyKO(false)
            if(seagull1.healthPoints <= 0 && seagull2.healthPoints <= 0 &&seagull3.healthPoints <= 0 &&seagull4.healthPoints <= 0){
                setEnemyKO(true);
            }
        }; 
        const barnacles = npcs.find(npc => npc.id === 1);
        const patches = npcs.find(npc => npc.id === 2);
        if(player.healthPoints >0 && enemyKO === false){
            let attackingParty = {}
            let defendingParty = {}
            if(currentTurn === 0){
                attackingParty = [player, barnacles, patches]
                defendingParty = [...enemies]
            } else {
                attackingParty = [...enemies]
                defendingParty = [player, barnacles, patches]
            }
            
            // console.log('roll', roll);
            // let attacker = {...currentTurn}
            // console.log('attacking', attacker)

            // const attackTotal = attacker.reduce((runTotal, character) => {
            //     return runTotal + character.attackPoints;
                
            // },0);

            // defendingParty.forEach(character => {
            //     let health = character.healthPoints;
            //     let armour = character.armour
            // })
            attackingParty.forEach((attackingCharacter) => {
                const attack = attackingCharacter.attackPoints;
                const roll = (Math.floor(Math.random() * 20 - 1) + 1)
                console.log('roll', roll);

                defendingParty.forEach(defendingCharacter => {

                    // let health = defendingCharacter.healthPoints;
                    const armour = defendingCharacter.armour
                    
                    if (defendingCharacter.healthPoints === 0) {
                        setEndBattle(true)
                        setNorthVisited(true) 
                        setHitMessage("Barnacles, Patches and yourself strike out at the gallus gulls and they immediately hit the deck! The crew clears them away, taking great care to remove all traces of feathers out of respect for Barnacles.")
                        
                    } else if (roll >= armour){

                        const newHp = Math.min(0, defendingCharacter.healthPoints - attack);
                        defendingCharacter.healthPoints = newHp;
                        console.log(`Updating ${defendingCharacter.name} hp by ${attack}, now ${defendingCharacter.healthPoints}`)
                        setHitMessage(`${attackingCharacter.name} hit ${defendingCharacter.name} for ${attack} damage!`)
                    } else {
                        setHitMessage(`${attackingCharacter.name} missed!`)
                    }
                })
            },0);

        }
    }

    


    

    

    return(
        <>
        {!show ? (
            <>
            <StoryText>
                You sail North upon The Seacleaver. It is bitterly cold but the sea is very calm and easy to sail through.
            </StoryText>
            <Patches>
                <PatchesText>
                    <strong>Patches: </strong>*SQUAWK!* RATS AHOY!
                </PatchesText>
            </Patches>
            <StoryText>
                Your eyes dart to Patches, who is pointing at the sky. You look up and see 5 unusually large seagulls screaming and diving to attack your crewmates, especially Barnacles. Barnacles swats away a seagull and draws his cutlass.
            </StoryText>
            <Barnacles>
                <BarnaclesText><strong>Barnacles: </strong>Cap'n! I know they're just birds but...</BarnaclesText>
            </Barnacles>
            <StoryText>
                Another seagull dives down to peck at Barnacles but is immediately cut down by Barnacles.
            </StoryText>
            <BottomDiv>
                <Button onClick={() => setShow(true)}>FIGHT!</Button>
                <Button onClick={backToSail}>Escape</Button>
            </BottomDiv>
            </>

        ) : (<>
        <HiddenDiv>
            <SeagullDiv>
                
                <StatText value={seagull1.healthPoints}>
                <StoryText>Seagull 1</StoryText>HP: {seagull1.healthPoints}</StatText>
            
            
                <StatText value={seagull2.healthPoints}><StoryText>Seagull 2</StoryText>HP: {seagull2.healthPoints}</StatText>
            </SeagullDiv>
            
            <SeagullDiv>
            
                <StatText value={seagull3.healthPoints}><StoryText>Seagull 3</StoryText>HP: {seagull3.healthPoints}</StatText>
            
            
                <StatText value={seagull4.healthPoints}><StoryText>Seagull 4</StoryText>HP: {seagull4.healthPoints}</StatText>
            </SeagullDiv>
            
            <TextDiv>
                <StoryText>{hitMessage}</StoryText>
            </TextDiv>
            <BottomDiv>
                <Button onClick={attack}>Attack!</Button>
                <Button onClick={backToSail}>Leave</Button>
            </BottomDiv>
        </HiddenDiv>
        </>    
        )}

        </>
    )

}

export default North;