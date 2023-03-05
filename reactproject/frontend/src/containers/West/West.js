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
    flex-direction: column;
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

const West = () => {

    return(

        <PageDiv>
            <StoryText>In the distance, you see a tiny island with a small, dark port town sticking out of the side of what looks to be an extinct volcano. You notice that there are no ships in the harbour and you cannot hear or see any signs of life coming from the port...</StoryText>
            <Barnacles>
                <BarnaclesText>
                    <strong>Barnacles: </strong>Can't remember the last time I visited Port Raven...it definitely didn't look like that before...
                </BarnaclesText>
            </Barnacles>
            <Patches>
                <PatchesText>
                    <strong>Patches: </strong>*growl* Thar be ghosts...curses...<StoryText>You notice that Patches is biting his lip, his brows furrowed. The second he notices you looking at him, he stands up straight and gives a mischevious smirk and sideways glance to Barnacles.</StoryText>*SQUAWK!* YOU KNOW CURSES, CALAMARI!!
                </PatchesText>
            </Patches>
            <Barnacles>
                <BarnaclesText><strong>Barnacles: </strong>SILENCE, PATCHES! <StoryText>Barnacles glares at Patches, his eyes bulging, before regaining his composure.</StoryText> Though he has a point, this place looks haunted and empty...we <em>could</em> have a look around, though I think we'd find nothing but trouble. What say you, Cap'n? </BarnaclesText>
            </Barnacles>

        <BottomDiv>
            <Button>Explore</Button>
            <Button>Leave</Button>
        </BottomDiv>
        </PageDiv>
    )

}

export default West;