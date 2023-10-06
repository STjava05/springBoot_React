import React, { useState } from 'react'
import axios from 'axios'
import {Link, useNavigate } from 'react-router-dom'

const AddUser = () => {
    let navigate = useNavigate();

    const [user, setUser] = useState({
        nom: "",
        prenom: "",
        email: "",
    });

    const { nom, prenom, email } = user;

    const onInputChange = e => {
        setUser({ ...user, [e.target.name]: e.target.value });
    }
    const onSubmit = async e => {
        e.preventDefault();
        await axios.post("http://localhost:8080/eleve", user);

        navigate('/');

       
    };

    return (
        <div className='container'>
            <div className='row'>
                <div className='col-md-6 offset-md-3 border rounded p-4 mt-2 shadow'>
                    <h2 className='text-center mb-4'>Register User</h2>
                    <form onSubmit={e => onSubmit(e)}>
                        <div className="mb-3">
                            <label htmlFor="nom" className="form-label">Nom</label>
                            <input type="text" className="form-control" name="nom"
                                onChange={(e) => onInputChange(e)} value={nom} placeholder="enter your name" />

                        </div>
                        <div className="mb-3">
                            <label htmlFor="prenom" className="form-label">Prenom</label>
                            <input type="text" className="form-control" name="prenom"
                                onChange={(e) => onInputChange(e)} value={prenom} placeholder="enter your prenom" />

                        </div>
                        <div className="mb-3">
                            <label htmlFor="email" className="form-label">Email</label>
                            <input type="text" className="form-control" name="email"
                                onChange={(e) => onInputChange(e)} value={email} placeholder="enter your mail" />

                        </div>
                        <button type="submit" className="btn btn-outline-primary">Submit</button>
                        <Link className="btn btn-outline-danger mx-2" to="/">Cancel</Link>
                    </form>
                </div>

            </div>

        </div>

    )
}



export default AddUser