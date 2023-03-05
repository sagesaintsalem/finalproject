import React, {useState, useEffect} from 'react'
import styled from 'styled-components';
import { Route, Routes, useNavigate, useParams } from 'react-router-dom';

const StoryText = styled.h4`
    color: yellow;
    font-size:28px;
    text-align: center;
`

const InputDiv = styled.div`
    display: flex;
    flex-direction: row;
    gap: 1em;
    justify-content: center;
`

const Button = styled.button`
    background-color: yellow;
    height: 22px;
    width: 82.35px;
    font-size: 16px;
    text-align: center;
`
const StatDiv = styled.div`
    display: flex;
    flex-direction: row;
    justify-content: space-around;
    align-items:center;
    color: yellow;
`

const Label = styled.label`
    text-align: center;
`
const Stat = styled.p`
    text-align: center;
`

const BottomDiv = styled.div`
    display: flex;
    flex-direction: row;
    gap: 1em;
    justify-content: center;
`

const CharCreation = () => {
    const navigate = useNavigate();

    const [name, setName] = useState("");
    const [str, setStr] = useState(0);
    const [mag, setMag] = useState(0);
    const [con, setCon] = useState(0);
    const [luck, setLuck] = useState(0);
    const [armour, setArmour] = useState(0);
    const [playerClass, setPlayerClass] = useState("");
    const [weapon, setWeapon] = useState("");
    const [hp, setHP] = useState(0);

    useEffect(() => {
        rollStats();
    }, 0)

    useEffect(() => {
        handleClassAndWeapon();
    }, "")

    const rollStats = () => {
        //let randInt = Math.floor(Math.random()* 18) + 5;
        setStr(Math.floor(Math.random()* 18) + 2);
        setCon(Math.floor(Math.random()* 18) + 2);
        setArmour(con + 3);
        setHP(con * 4);
        setMag(Math.floor(Math.random()* 18) + 2);
        setLuck(Math.floor(Math.random()* 18) + 2);
    }

    const handleClassAndWeapon = () => {
        if(mag > str){
            setPlayerClass("Mage")
        } else {
            setPlayerClass("Warrior")
        };
        if(playerClass == "Mage"){
            setWeapon("staff")
        } else {
            setWeapon("cutlass")
        };
    }

    const handleName = (event) => {
        event.preventDefault()
        rollStats();
    }

    const toNextPage =(event) => {
        navigate('/intro')
    }

    

    return(
        <div>
            <StoryText>You are the captain of the pirate ship, the Seacleaver!
                What is your name?
            </StoryText>
            <InputDiv>
                <input></input>
                <Button onClick={handleName}>Enter</Button>
            </InputDiv>
            <StatDiv>
                <Label><strong>Attack: </strong></Label>
                <Stat onChange={handleClassAndWeapon}>{str}</Stat>

                <Label><strong>Magic: </strong></Label>
                <Stat>{mag}</Stat>

                <Label><strong>Luck: </strong></Label>
                <Stat>{luck}</Stat>

                <Label><strong>Constitution: </strong></Label>
                <Stat>{con}</Stat>

                <Label><strong>HP: </strong></Label>
                <Stat>{hp}</Stat>

                <Label><strong>Armour: </strong></Label>
                <Stat>{armour}</Stat>

                <Label><strong>Class: </strong></Label>
                <Stat>{playerClass}</Stat>

                <Label><strong>Weapon: </strong></Label>
                <Stat>{weapon}</Stat>
            </StatDiv>
            <BottomDiv>
                <Button onClick={rollStats}>Reroll</Button>
                <Button onClick={toNextPage}>Continue</Button>

            </BottomDiv>
        </div>



    )
}

export default CharCreation;