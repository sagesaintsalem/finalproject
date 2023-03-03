import React, {useState, useEffect} from 'react'
import styled from 'styled-components';
import { Route, Routes, useNavigate, useParams } from 'react-router-dom';
import Request from "../helpers/request";
import NPC from "../components/npcs/NPC";

const Homepage = () => {

const [player, setPlayer] = useState([])
const [npcs, setNpcs] = useState([])
const [enemies, setEnemies] = useState([])
const [ships, setShips] = useState([])
const [raids, setRaids] = useState([])
const [kraken, setKraken] = useState([])

useEffect(()=>{
    const request = new Request();

    const npcPromise = request.get('/api/npcs');
    const enemyPromise = request.get('/api/enemies');
    const shipPromise = request.get('/api/ships');
    const raidPromise = request.get('/api/raids');
    const krakenPromise = request.get('/api/bosses');

    Promise.all([npcPromise, enemyPromise, shipPromise, raidPromise, krakenPromise])
        .then((data) => {
            setNpcs(data[0])
            setEnemies(data[1])
            setShips(data[2])
            setRaids(data[3])
            setKraken(data[4])
        })
}, [])

    const findNPC = (id) => {
        return npcs.find((npc) => {
        return npc.id === parseInt(id);
        })
    }

    const ShowDamnNPC = () => {
        const {id} = useParams();
        let foundNPC = findNPC(id)

        return <NPC npc={foundNPC}/>
    }









    return(
        <div>
            <h1>JAVA STILL SUCKS</h1>
        </div>
    )
}

export default Homepage;