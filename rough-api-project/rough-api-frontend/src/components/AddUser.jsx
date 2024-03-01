import React, { useState } from 'react'
import './style.css'
import contactService from '../api/ContactService'

function AddUser() {
    const[contact, setContact] = useState({
        name: "",
        title: "",
        email: "",
        phone: "",
        address: ""
    })

    const handleChange = (e) => {
        setContact({...contact, [e.target.name]: e.target.value})
    }

    const addContact = async () => {
        try {
            await contactService.createContact(contact);
            alert('Saved successfully');
        } catch (error) {
            console.error('Error saving contact:', error);
            alert('Error saving contact');
        }
    };

    return (
        <div className='addUser'>
            <div className="addUser-image"></div>
            <div className='addUser-form'>
                <input type="text" placeholder='Name' name='name' onChange={e => handleChange(e)} />
                <input type="text" placeholder='Title' name='title' onChange={e => handleChange(e)} />
                <input type="text" placeholder='Email' name='email' onChange={e => handleChange(e)} />
                <input type="text" placeholder='Phone' name='phone' onChange={e => handleChange(e)} />
                <input type="text" placeholder='Address' name='address' onChange={e => handleChange(e)} />
                <button onClick={addContact}>Submit</button>
            </div>
        </div>
    )
}

export default AddUser
