import React, {Component} from "react";
import {BrowserRouter as Router, Route, Routes} from 'react-router-dom'
import withNavigation from './WithNavigation'
import withParam from './WithParams'
import HeaderComponent from './HeaderComponent'

class MyDojoApp extends Component{
    render(){
        const HeaderComponentWithNavigation = withNavigation(HeaderComponent);

        return(
            <div className="MyDojoApp">
                <meta charset="utf-8"/>
                <meta name="viewport" content="width=device-width, initial-scale=1" />
                <link rel="preconnect" href="https://fonts.googleapis.com" />
                <link rel="preconnect" href="https://fonts.googleapis.com" />
                <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin />
                <link href="https://fonts.googleapis.com/css2?family=Shadows+Into+Light&display=swap" rel="stylesheet" />

                <script src="https://code.jquery.com/jquery.js"></script>
                <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

                <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous" />

                <script crossorigin src="https://unpkg.com/react@16/umd/react.development.js"></script>
                <script crossorigin src="https://unpkg.com/react-dom@16/umd/react-dom.development.js"></script>
                <script crossorigin src="https://cdnjs.cloudflare.com/ajax/libs/babel-standalone/6.26.0/babel.js"></script>
                <link rel="stylesheet" href="/src/styles.css"></link>


                <Router>
                    <HeaderComponentWithNavigation/>

                </Router>
            </div>
        )
    }
}

export default MyDojoApp