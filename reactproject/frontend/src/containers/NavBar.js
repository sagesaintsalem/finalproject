import React, {useState} from 'react'
import styled from 'styled-components';
import { useNavigate } from 'react-router-dom';
import Request from '../helpers/request';

const NavDiv = styled.div`
    padding: 0.1em;
    display: flex;
    flex-direction: row;
`
const TextWrap = styled.div`
    display: flex;
    flex-direction: row;
    justify-content: space-between;
`

const NavText = styled.h4`
    color: yellow;
    font-size:14px;
`

const NavBar = ({player, ships}) => {
    
    const seacleaver = ships.find(ship => ship.id === 1);
    
    
    return(
        
        <>
            
                <NavText value={player}><strong>Captain {player.name} - </strong>HP: {player.healthPoints} Armour: {player.armour}  Class: {player.playerClass} Weapon: {player.weapon}</NavText>
          
                <NavText value={seacleaver}><strong>The Seacleaver - </strong>HP: {seacleaver.healthPoints} Armour: {seacleaver.armour} Coffers: {seacleaver.coffers}</NavText>
           
        </>
    )}

export default NavBar;