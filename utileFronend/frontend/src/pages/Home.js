import React,{useEffect, useState} from 'react'
import axios from 'axios'
import {Link, useParams} from 'react-router-dom'


const Home = () => {
const [users, setUsers] =useState([])

const {id}=useParams();

useEffect(() => {
    loadUsers()
}, [])

const loadUsers = async () => {
    const result = await axios.get("http://localhost:8080/eleves")
    
    setUsers(result.data) 
    console.log(result.data)  
}

const deleteUser = async id => {
    await axios.delete(`http://localhost:8080/eleve/${id}`)
    loadUsers()
}


  return (
    <div className='container'>
        <div className='py-4'>
        <table className="table border shadow">
  <thead>
    <tr>
      <th scope="col">#</th>
      <th scope="col">Nom</th>
      <th scope="col">Prenom</th>
      <th scope="col">Email</th>
      <th scope="col">Actions</th>
    </tr>
  </thead>
  <tbody>
     {
            users.map((user, index) => (
                <tr>
                <th scope="row">{index + 1}</th>
                <td>{user.nom}</td>
                <td>{user.prenom}</td>
                <td>{user.email}</td>
                <td>
                    <Link className="btn btn-primary mx-2"to={`/viewUser/${user.id}`}>View</Link>
                    <Link className="btn btn-outline-primary mx-2"to={`/editUser/${user.id}`}>Edit</Link>
                    <button onClick={()=>deleteUser(user.id)} className="btn btn-danger">Delete</button>
                </td>
            </tr>
            ))
     }

  
    
  </tbody>
</table>
        </div>
            

    </div>
  )
}

export default Home