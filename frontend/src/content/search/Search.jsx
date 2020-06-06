import React, {useState} from "react";
import './Search.css'
import {IoIosSearch, IoIosClose} from 'react-icons/io';
import {loadMore, search} from "../../rest/EbayService";
import Examples from "./Examples";
import SearchResults from "../search-result/SearchResults";
import ExtendedSearch from "./ExtendedSearch";
import SearchResultCard from "../search-result-card/SearchResultCard";

export default function Search({examples, categories}) {

    const [searchString, setSearchString] = useState('');
    const [showPrompts, setShowPrompts] = useState(false);
    const [searchResult, setSearchResult] = useState(null);
    const [chosenCategories, setChosenCategories] = useState([]);
    const [chosenItem, setChosenItem] = useState(null);

    const updateSearch = (val) => setSearchString(val);

    const doSearch = async () => {
        setShowPrompts(false);
        let pastSearches = localStorage['searches'];
        if (!pastSearches) localStorage['searches'] = `${searchString}||`;
        else if (!pastSearches.split('||').includes(searchString)) localStorage['searches'] = `${pastSearches}${searchString}||`;

        const response = await search(searchString, chosenCategories.join());
        const data = response.data;
        if (data && data.itemSummaries) setSearchResult(data);
    };

    const loadAdditionalItems = async () => {
        const response = await loadMore(searchResult.next);
        const newData = response.data;
        newData.itemSummaries = [ ...searchResult.itemSummaries, ...newData.itemSummaries ];
        setSearchResult(newData);
    }

    const choosePrompt = (prompt) => {
        setSearchString(prompt);
        setShowPrompts(false);
    }

    const getPrompts = () => localStorage['searches'] ? localStorage['searches'].split('||').splice(1).reverse() : [];

    return <div className={`search-component-wrapper ${searchResult ? 'open' : ''}`}>
        <div className='search-container'>
            <input className='search-input'
                   placeholder={`Let's find some shoes!`}
                   onChange={(e) => updateSearch(e.target.value)} //since React 16 they say it's fine to set state inline
                   value={searchString}
                   onFocus={() => setShowPrompts(true)}
            />
            {searchString && <IoIosClose size={30} onClick={() => setSearchString('')} className='with-pointer'/>}
            <IoIosSearch color={'grey'} size={40} className='with-pointer' onClick={() => doSearch()}/>
            {showPrompts && !!searchString &&
            <div className='prompts-container'>
                {getPrompts().map(prompt =>
                    <span key={prompt}
                          className='prompts-container-text'
                          onClick={() => choosePrompt(prompt)}>
                        {prompt}
                    </span>)}
            </div>
            }
        </div>
        <ExtendedSearch categories={categories}
                        chosenCategories={chosenCategories}
                        setChosenCategories={setChosenCategories}/>
        <Examples visible={searchResult === null} examples={examples}/>
        { searchResult &&  <SearchResults results={searchResult.itemSummaries} choose={(item) => setChosenItem(item)}/> }
        {chosenItem && <SearchResultCard entry={chosenItem} close={()=> setChosenItem(null)}/> }
        { searchResult && <div className='load-more-button' onClick={()=> loadAdditionalItems()}> <span>Load more</span> </div>}
    </div>
}