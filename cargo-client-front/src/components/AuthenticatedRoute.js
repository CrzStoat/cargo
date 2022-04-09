import React, {Component} from 'react'
import {Redirect, Route} from 'react-router-dom'
import {isUserLoggedIn} from "../services/AuthenticationService";

const AuthenticatedRoute = ({ component: Component, ...rest }) => (
    <Route {...rest} render={props => (
        isUserLoggedIn() ? (
            <Component {...props} />
        ) : (
            <Redirect to={{ pathname: '/login' }} />
        )
    )} />
)



export default AuthenticatedRoute
