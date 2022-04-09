import React, {Component} from 'react'
import {createJWTToken, executeBasicAuthenticationService,} from "../services/AuthenticationService";
import AuthContext from "../context/AuthContext";

class LoginComponent extends Component {

    constructor(props) {
        super(props)

        this.state = {
            username: '',
            password: '',
            hasLoginFailed: false,
            showSuccessMessage: false
        }

        this.handleChange = this.handleChange.bind(this)
        this.loginClicked = this.loginClicked.bind(this)
    }

    handleChange(event) {
        this.setState(
            {
                [event.target.name]: event.target.value
            }
        )
    }

    loginClicked() {
       let login = this.context.Login
        console.log(this.state.username, this.state.password)
        executeBasicAuthenticationService(this.state.username, this.state.password)
            .then((response) => {
                login({
                    username: this.state.username,
                    token: createJWTToken(response.data.token)
                }).then(() => {
                   this.props.history.push(`/sensors`)
               })
            }).catch(() => {
            console.log("catch")
            this.setState({showSuccessMessage: false})
            this.setState({hasLoginFailed: true})
        })
    }

    render() {

        if (this.context.signed){

            return (
                <div>Вы уже вошли в систему под пользователем: {this.context.user.username}</div>
                //<Redirect to={{pathname: '/sensors'}}/>
                )
        }

        return (
            <div>
                <h1>Login</h1>
                <div className="container">
                    {this.state.hasLoginFailed && <div className="alert alert-warning">Invalid Credentials</div>}
                    {this.state.showSuccessMessage && <div>Login Successful</div>}
                    User Name: <input type="text" name="username" value={this.state.username}
                                      onChange={this.handleChange}/>
                    Password: <input type="password" name="password" value={this.state.password}
                                     onChange={this.handleChange}/>
                    <button className="btn btn-success" onClick={this.loginClicked}>Login</button>
                </div>
            </div>
        )
    }
}
LoginComponent.contextType = AuthContext;



export default LoginComponent
