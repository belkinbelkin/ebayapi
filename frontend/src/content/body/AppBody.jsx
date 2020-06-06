import React, {useEffect, useState} from "react";
import './AppBody.css';
import Search from "../search/Search";
import {getCategories, getExamples} from "../../rest/EbayService";

export default function AppBody() {

    useEffect(() => {
        fetchData()
    }, []);

    const [examples, setExamples] = useState(null);
    const [categories, setCategories] = useState(null);

    const fetchData = async () => {
        const result = await getExamples();
        setExamples(result.data);
        const categoriesResponse = await getCategories();
        setCategories(categoriesResponse.data);
    }

    return <div className='body-wrapper'>
        <Search examples = {examples} categories={categories}/>
    </div>
}