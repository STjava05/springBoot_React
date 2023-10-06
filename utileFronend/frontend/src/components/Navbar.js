import React from 'react'
import {Link} from 'react-router-dom'

const Navbar = () => {
  return (
    <div>
       
<nav className="navbar bg-primary mt-3 ">
  <div className="container-fluid">
    <Link className="navbar-brand mb-0 h1" to="/">Full Stack Application</Link>

    <Link className='btn btn-outline-warning' to="/addUser">AddUser</Link>
  </div>
  
</nav>

    </div>
  )
}

export default Navbar