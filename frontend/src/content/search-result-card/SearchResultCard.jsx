import React from "react";
import './SearchResultCard.css';
import {IoIosClose} from 'react-icons/io';

export default function SearchResultCard({entry, close}) {


    return <div className='result-card-container'>
        <div className='card-buttons-container'>
            <IoIosClose size={40} onClick={close}/>
        </div>
        <div className='image-and-info'>
            <img src={entry.image.imageUrl} alt={'N/A'} className='card-image'/>
            <div className='info'>
                <div>
                    <span>{entry.title} {entry.price.value}{entry.price.currency}</span>
                </div>
                <div>
                    <span>Condition: </span>
                    <span>{entry.condition}</span>
                </div>
                <div>
                    <span>Seller: </span>
                    <span>{entry.seller.username}</span>
                </div>
                <div>
                    <span>Score: </span>
                    <span>{entry.seller.feedbackPercentage}</span>
                </div>
                <a href={entry.itemWebUrl} target='_blank'>
                    <div className='buy-button'>
                        <span>Buy now on eBay</span>
                    </div>
                </a>
            </div>
        </div>

        <div>
            {entry.additionalImages.map(imageObj => <img key={imageObj.imageUrl} src={imageObj.imageUrl} alt={'N/A'}
                                                         className='card-image'/>)}
        </div>
    </div>
}