import React from "react";
import './Header.css';
import { GiRunningShoe } from "react-icons/gi";


export default function Header() {
    return <div className='header-wrapper'>
        <div className='header-label-container'>
            <GiRunningShoe color='#fff' size={40}/>
            <span className='header-wrapper-text'>Ultimate Mega Shoe Shop</span>
        </div>
    </div>
}