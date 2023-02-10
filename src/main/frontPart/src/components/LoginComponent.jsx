import React, {Component} from "react"
import AuthenticationService from "./AuthenticationService"

class LoginComponent extends Component{
    constructor(props){
        super(props)
        this.state = {
            username: 'user',
            password: 'password',
            hasLoginFailed: false,
            showSuccessMessage: false
        }
        this.hadleChange = this.hadleChange.bind(this)
        this.loginClicked = this.loginClicked.bind(this)
    }

    hadleChange(event){
        this.setState(
            {
                [event.target.name]:event.target.value
            }
        )
    }

    loginClicked(){
        //hardcoded:
        if(this.state.username==='in28minutes' && this.state.password==='dummy'){
            AuthenticationService.registerSuccessfulLogin(this.state.username, this.state.password)
            this.props.navigate(`/welcome/${this.state.username}`)
        } else {
            this.setState(
                {
                    showSuccessMessage: false,
                    hasLoginFailed: true
                }
            )
        }
    }

    render() {
        return(
            <>
            <h1>Login</h1>
            <div className="container">
            {this.state.hasLoginFailed && <div className="alert alert-warning">Invalid Credentials</div>}
            {this.state.showSuccessMessage && <div>Login Successful!</div>}
            User Name: <input type="text" name="username" value={this.state.username} onChange={this.hadleChange}/>
            Password: <input type="password" name="password" value={this.state.password} onChange={this.hadleChange}/>
            <button className ="btn btn-success" onClick={this.loginClicked}>Login</button>
            </div>
            </>
        )
    }
}

export default LoginComponent