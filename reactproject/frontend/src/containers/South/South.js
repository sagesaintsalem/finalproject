import React, {useState, useEffect} from 'react'
import styled from 'styled-components';
import { Route, Routes, useNavigate, useParams } from 'react-router-dom';

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
    padding: 0.3em;
    display: flex;
    flex-direction: column;
    justify-content: center;
`

const Patches = styled.div`
    padding: 0.3em;
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


const South = () => {


    return (

        <PageDiv>
            <StoryText>In the distance, you see the glittering Port Rouge: famous for being a home away from home for the King's Navy and his wealthier, more esteemed subjects. The town is so named for its brighly-painted red buildings.</StoryText>

            <Barnacles>
                <BarnaclesText><strong>Barnacles: </strong>Ah, Port Rouge. The biggest, gaudiest jewel in the King's crown...</BarnaclesText>
                <StoryText>You see Barnacles' tentacles curl inward as he stares out to the port.</StoryText>
            </Barnacles>
            <Patches>
                <PatchesText><strong>Patches: </strong>*SQUAWK!* LAWFUL AND RICH! LAWFUL AND RICH!</PatchesText>
            </Patches>
            <Barnacles>
                <BarnaclesText><strong>Barnacles: </strong>Indeed. Though stealing from the King's favourites would certainly draw his and his Navy's ire...what do you think, Cap'n?</BarnaclesText>
            </Barnacles>
            <BottomDiv>
                <Button>RAID!</Button>
                <Button>Leave</Button>
            </BottomDiv>

        </PageDiv>
    )

}

export default South;