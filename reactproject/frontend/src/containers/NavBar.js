import React from 'react'
import styled from 'styled-components';


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
        
        <TextWrap>
            
                <NavText value={player}><strong>Captain {player.name} - </strong>HP: {player.healthPoints} Armour: {player.armour}  Class: {player.playerClass} Weapon: {player.weapon}</NavText>
          
                <NavText value={seacleaver}><strong>The Seacleaver - </strong>HP: {seacleaver.healthPoints} Armour: {seacleaver.armour} Coffers: {seacleaver.coffers}</NavText>
           
        </TextWrap>
    )}

export default NavBar;