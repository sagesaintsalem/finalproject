import React, {useState, useEffect} from 'react'
import styled from 'styled-components';
import { Route, Routes, useNavigate, useParams } from 'react-router-dom';
import Request from "../helpers/request";
import NPC from "../components/npcs/NPC";

const HomeTitle = styled.h1`
    text-align: center;
    font-size: 60px;
    color: yellow;
`

const HomeSubTitle = styled.h3`
    text-align: center;
    color: yellow;
    font-size:40px;
`

const ButtonDiv = styled.div`
    display: flex;
    justify-content: center;
`

const Button = styled.button`
    background-color: yellow;
    height: 50px;
    width: 92.35px;
    font-size: 30px;
    text-align: center;
`

const Homepage = () => {
const navigate = useNavigate();

// const [player, setPlayer] = useState([])
// const [npcs, setNpcs] = useState([])
// const [enemies, setEnemies] = useState([])
// const [ships, setShips] = useState([])
// const [raids, setRaids] = useState([])
// const [kraken, setKraken] = useState([])

// useEffect(()=>{
//     const request = new Request();
    

//     const npcPromise = request.get('/api/npcs');
//     const enemyPromise = request.get('/api/enemies');
//     const shipPromise = request.get('/api/ships');
//     const raidPromise = request.get('/api/raids');
//     const krakenPromise = request.get('/api/bosses');

//     Promise.all([npcPromise, enemyPromise, shipPromise, raidPromise, krakenPromise])
//         .then((data) => {
//             setNpcs(data[0])
//             setEnemies(data[1])
//             setShips(data[2])
//             setRaids(data[3])
//             setKraken(data[4])
//         })
// }, [])

    


    const redirectToCreationPage = (event) => {
        navigate("/charcreation");
    }







    return(
        <div>
            <HomeTitle>ARRRRPG!</HomeTitle>
            <HomeSubTitle>A text-based pirate RPG!</HomeSubTitle>
            <ButtonDiv>
                <Button onClick={redirectToCreationPage}>Start</Button>
            </ButtonDiv>
        </div>
    )
}

export default Homepage;