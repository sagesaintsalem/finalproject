import React, {useState, useEffect} from 'react'
import styled from 'styled-components';
import { Route, Routes, useNavigate, useParams } from 'react-router-dom';


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