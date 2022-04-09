import React from "react";
import {Route, Switch} from "react-router-dom";
import {SingleSensorComponent} from "./SingleSensorComponent";
import SensorsComponent from "./SensorsComponent";
import LoginComponent from "./LoginComponent";

const Routes = () => {
    return (
        <Switch>
            {/*<AuthenticatedRoute path='/profile' component={ProfileComponent}/>*/}
            <Route path='/sensors/:id' component={SingleSensorComponent}/>
            <Route path='/sensors' component={SensorsComponent}/>
            <Route path='/login' component={LoginComponent}/>
        </Switch>
    )
}

export default Routes;
