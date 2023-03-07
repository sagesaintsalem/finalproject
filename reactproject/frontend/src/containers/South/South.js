import React, {useState} from 'react'
import styled from 'styled-components';
import { useNavigate } from 'react-router-dom';
import Request from '../../helpers/request';

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

const HiddenDiv = styled.div`
    padding: 0.5em;
    display: flex;
    flex-direction: column;
    justify-content: center;
`


const South = ({raids, updateRaid, ships, updateShip}) => {
    const [show, setShow] = useState(false);
    const navigate = useNavigate();
    const request = new Request();

    const backToSail = (event) => {
        navigate('/sail')

    }

    const seacleaver = ships.find(ship => ship.id === 1);
    const rouge = raids.find(raid => raid.id === 1);

    const stolenMoney = (event) => {
        const updatedCoffers = seacleaver.coffers + 3000;
        const richerShip = {
		name: "The Seacleaver",
		coffers: updatedCoffers,
		healthPoints: seacleaver.healthPoints,
		armour: 16,
		attkPoints: 20,
		status: "SAILING"};
        request.put('/api/ships/' + seacleaver.id, richerShip).then(data => data.json()).then(data => updateShip(data));
        

        const rougeLoot = {
            portName:"Port Rouge",
            loot: 0,
            specialWeapon: null
        }
        request.put('/api/raids/' + rouge.id, rougeLoot).then(data => data.json()).then(data => updateRaid(data));

        Promise.all([updateShip, updateRaid])
        navigate('/sail')
    }

    return (

        <PageDiv>
            {!show ? (
                <><StoryText>In the distance, you see the glittering Port Rouge: famous for being a home away from home for the King's Navy and his wealthier, more esteemed subjects. The town is so named for its brighly-painted red buildings.</StoryText><Barnacles>
                    <BarnaclesText><strong>Barnacles: </strong>Ah, Port Rouge. The biggest, gaudiest jewel in the King's crown...</BarnaclesText>
                    <StoryText>You see Barnacles' tentacles curl inward as he stares out to the port.</StoryText>
                </Barnacles><Patches>
                        <PatchesText><strong>Patches: </strong>*SQUAWK!* LAWFUL AND RICH! LAWFUL AND RICH!</PatchesText>
                    </Patches><Barnacles>
                        <BarnaclesText><strong>Barnacles: </strong>Indeed. Though stealing from the King's favourites would certainly draw his and his Navy's ire...what do you think, Cap'n?</BarnaclesText>
                    </Barnacles><BottomDiv>
                        <Button onClick={() => setShow(true)}>RAID!</Button>
                        <Button onClick={backToSail}>Leave</Button>
                    </BottomDiv></>
                ) : (


                <HiddenDiv>
                    <StoryText>Your crew yells in excitement, swords and staffs aloft, as your ship advances to Port Rouge!</StoryText>
                    <StoryText>After 3 days of rampaging through the streets, dodging and slicing the King's guards and sailors and a lot of stealing, you leave with The Seacleaver {rouge.loot} gold pieces richer!</StoryText>
                    <Button onClick={stolenMoney}>Continue</Button>
                </HiddenDiv>
            )}
        </PageDiv>
    )

}

export default South;