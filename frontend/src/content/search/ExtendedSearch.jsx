import React, {useState} from "react";

export default function ExtendedSearch({categories, chosenCategories, setChosenCategories}) {

    const [isOpen, setIsOpen] = useState(false);

    const toggle = () => {
        if (isOpen) {
            setIsOpen(false);
            setChosenCategories([]);
        } else setIsOpen(true);
    }

    const clickCategory = (category) => {
        if (chosenCategories.indexOf(category.id) !== -1) setChosenCategories(chosenCategories.filter(x => x !== category.id));
        else setChosenCategories([...chosenCategories, category.id])
    }

    return <div className='extended-search-container'>
        <div className='button-label' onClick={() => toggle()}>
            <span>Extended search </span>
            <div className='extended-search-button'>{isOpen ? '-' : '+'}</div>
        </div>
        {
            isOpen && <div className='categories-container'>
                {categories.map(category => <div key={category.id} className='category'>
                    <input type="checkbox" id={category.id} name={category.id} value={category.id}
                           onClick={() => clickCategory(category)}/>
                    <label htmlFor={category.id}>{category.name}</label>
                </div>)}
            </div>
        }
    </div>

}