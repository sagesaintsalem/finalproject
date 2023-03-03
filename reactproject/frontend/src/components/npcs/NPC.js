import React from "react";
import { Link } from 'react-router-dom';


const NPC = ({npc}) => {

    const url = "/npcs/" + npc.id;



    return(
        <div>
            <p>
                <Link to={url} className="name">
                    {npc.name}
                </Link>
            </p>
        </div>
    )
}

export default NPC;