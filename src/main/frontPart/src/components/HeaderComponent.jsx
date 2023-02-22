import React, {Component} from "react";
import AuthenticationService from "./AuthenticationService";
import { Link } from "react-router-dom";
import Container from 'react-bootstrap/Container';
import Nav from 'react-bootstrap/Nav';
import Navbar from 'react-bootstrap/Navbar';


class HeaderComponent extends Component {
    render(){
        const isUserLoggedIn = AuthenticationService.isUserLoggedIn();
        return(
            <>
                <Nav className="navbar sticky-top navbar-expand-lg navbar-light bg-light"  >
                <a className="navbar-brand" href="/"> <div>My Dojo</div></a>
                <button className="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarTogglerDemo03" aria-controls="navbarTogglerDemo03" aria-expanded="false" aria-label="Toggle navigation">
                    <span className="navbar-toggler-icon"></span>
                </button>
      

                    <ul className="navbar-nav">
                        <li><Link className="nav-link" to="/">Home</Link></li>
                        <li><Link className="nav-link" to="/about">About</Link></li>
                        <li><Link className="nav-link" to="/coaches">Our coaches</Link></li>
                        <li><Link className="nav-link" to="/tournaments">Tournaments</Link></li>
                        <li><Link className="nav-link" to="/classes">Class Schedule</Link></li>
                    </ul>
                    <ul className="navbar-nav navbar-collapse justify-content-end">
                        {isUserLoggedIn && <li><Link className="nav-link" to="/login">Login</Link></li>}
                        {isUserLoggedIn && <li><Link className="nav-link" to="/register">Register</Link></li>}

                        {!isUserLoggedIn && <li><Link  className="nav-link" to="/logout" onClick={AuthenticationService.logout} >Logout</Link></li>}
                    </ul>
                </Nav>
            </>
        )
    }
}

export default HeaderComponent