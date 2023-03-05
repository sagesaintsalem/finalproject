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

const East = () => {

    return(
        <>
            <p>Oops, nothing here!</p>
        </>
    )

}

export default East;