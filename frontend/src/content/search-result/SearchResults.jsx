import React from "react";
import './SearchResult.css';

export default function SearchResults({results, choose}) {


    return <div className='search-results-container'>
        {
            (results || []).map(item =>
                <div key={item.itemId} className='result-item-wrapper' onClick={()=> choose(item)}>
                    <img className='result-item-image' src={item.image.imageUrl} alt={'N/A'}/>
                    <span className='result-item-name'>{item.title}</span>
                    <span className={'result-item-price'}>{item.price.value}{item.price.currency}</span>
                </div>
            )
        }
    </div>
}

