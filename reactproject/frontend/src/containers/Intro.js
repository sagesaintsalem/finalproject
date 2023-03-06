import React, {useState, useEffect} from 'react'
import styled from 'styled-components';
import { Route, Routes, useNavigate, useParams } from 'react-router-dom';



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


const Intro = ({player}) => {
    const navigate = useNavigate();

    const toNextPage = (event) => {
        navigate('/sail');
    }


    return (
        <>
        <Barnacles>
            <TextDiv>
                <StoryText>You leave your cabin and step out on deck. It is a cool, grey morning. You can hear your crew quietly talking amongst themselves as they work, the faint sound of seagulls and the low roar of the sea. A large man with an octopus head approaches you. </StoryText>

                <BarnaclesText><strong>Barnacles: </strong>Good Morning, Cap'n {player.name}! </BarnaclesText>
                
                <StoryText>Barnacles is your mild-mannered and level-headed First Mate. He is a warrior, a great swordsman, and cursed to look like an octopus after spurning a sea witch's advances.</StoryText>
                <StoryText>Behind Barnacles, you see a smirking man with a human head, a long blue scarf bundled around his neck, and a seemingly annoyed parrot on his shoulder.</StoryText>
            </TextDiv>
            <img src="https://live.staticflickr.com/65535/52728245768_0cbb4b803a.jpg" width="187.5" height="250" alt="barnacles"/>
        </Barnacles>

        <Patches>
        <img src="https://live.staticflickr.com/65535/52727086312_1cfcb7738d.jpg" width="187.5" height="250" alt="patches"/>
            <TextDiv>
                <PatchesText><strong>Patches (through Polly): </strong>*SQUAWK!* COLD MORNING! </PatchesText>
                <StoryText>Patches is a mage who can summon lightning. He lost the ability to speak after a run-in with some disgruntled fishermen. He now speaks through his parrot.
                </StoryText>
                <StoryText>Barnacles and Patches have a cordial but tense relationship given Patches' voracious appetite for seafood.</StoryText>
            </TextDiv>
        </Patches>
        <BottomDiv>
            <Button onClick={toNextPage}>Continue</Button>
        </BottomDiv>
        </>

    )

}

export default Intro;