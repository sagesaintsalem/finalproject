import React, {useState, useEffect} from 'react'
import styled from 'styled-components';
import { Route, Routes, useNavigate, useParams } from 'react-router-dom';
import Request from '../../helpers/request';

const PageDiv = styled.div`
    display: flex;
    flex-direction: column;
    justify-content: center;
`

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

const North = ({enemies, updateEnemy, npcs, updateNPC, player}) => {

    const [show, setShow] = useState(false);
    const navigate = useNavigate();
    const request = new Request();

    const backToSail = (event) => {
        navigate('/sail')
    }

    const barnacles = npcs.find(npc => npc.id === 1);
    const patches = npcs.find(npc => npc.id === 2);
    const seagull1 = enemies.find(enemy => enemy.id === 1);
    const seagull2 = enemies.find(enemy => enemy.id === 2);
    const seagull3 = enemies.find(enemy => enemy.id === 3);
    const seagull4 = enemies.find(enemy => enemy.id === 4);

    const damage = player.attackPoints;
    const magDamage = player.magicPoints;

    const roll = (targetChar) => {
        let dice = (Math.floor(Math.random() * 20 - 1) + 1)
        if (dice > targetChar.armour){
            <StoryText>HIT!</StoryText>
        }
    }


    
    // const attack = () => {
        
    // }
    

    const thunderBolt = () => {
        if (player.playerClass === "MAGE"){
            let thunderDamage = magDamage * 2;
            <StoryText>You strike your enemy with lightning!</StoryText>
        } else {
            <StoryText>You try to summon lightning, but only muster static electricity...</StoryText>
        }
    }

    const trueStrike = () => {
        if (player.playerClass === "WARRIOR"){
            let hardDamage = damage * 2;
            <StoryText>You swing your cutlass forcefully and strike your enemy's weak spot!</StoryText>
        } else {
            <StoryText>You try to jab the enemy with your staff but you don't even give them a splinter...</StoryText>
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
            <TextDiv>
                <StoryText>Seagull 1</StoryText>
                <StatText value={seagull1.healthPoints}>HP: {seagull1.healthPoints}</StatText>
            </TextDiv>
            <TextDiv>
            <StoryText>Seagull 2</StoryText>
                <StatText value={seagull2.healthPoints}>HP: {seagull2.healthPoints}</StatText>
            </TextDiv>
            <TextDiv>
            <StoryText>Seagull 3</StoryText>
                <StatText value={seagull3.healthPoints}>HP: {seagull3.healthPoints}</StatText>
            </TextDiv>
            <TextDiv>
            <StoryText>Seagull 4</StoryText>
                <StatText value={seagull4.healthPoints}>HP: {seagull4.healthPoints}</StatText>
            </TextDiv>

            <BottomDiv>
                <Button>Attack!</Button>
                <Button>Self-heal</Button>
                <Button></Button>
            </BottomDiv>
        </HiddenDiv>
        </>    
        )}

        </>
    )

}

export default North;