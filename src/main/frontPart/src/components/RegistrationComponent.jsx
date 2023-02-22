import React, {Component} from "react"
import AuthenticationService from "./AuthenticationService"
import UserDataService from "./UserDataService"

class RegistrationComponent extends Component{
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

    registrationClicked(){
        const user = UserDataService.retrieveUser(this.state.username)
        if(!user){
            UserDataService.registerUser(this.state.username, this.state.password)
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
            {this.state.hasLoginFailed && <div className="alert alert-warning">This user already exists</div>}
            {this.state.showSuccessMessage && <div> Your are registered!</div>}
            User Name: <input type="text" name="username" value={this.state.username} onChange={this.hadleChange}/>
            Password: <input type="password" name="password" value={this.state.password} onChange={this.hadleChange}/>
            <button className ="btn btn-success" onClick={this.registerClicked}>Register</button>
            </div>
            </>
        )
    }
}

export default RegistrationComponent