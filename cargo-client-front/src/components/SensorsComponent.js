import React from "react";
import {getAllSensors} from "../services/SensorsService";

class SensorsComponent extends React.Component {

    constructor() {
        super();
        this.state = {
            sensors: [],
            error: null
        }
    }

    tick() {
        getAllSensors().then((response) => {
            this.setState({
                error: null,
                sensors: response.data
            })
        }).catch((error) => {
            this.setState({error: error.response})
        })
    }

    componentDidMount() {
        this.tick()
        this.interval = setInterval(() => this.tick(), 10000);
    }

    componentWillUnmount() {
        clearInterval(this.interval);
    }

    render() {
        const error = this.state.error;
        if (error){
            return <small>{error.data.error}</small>
        }
        return (
            <div style={{marginRight: "10px", marginLeft: "10px"}} >
                <h1 className="text-center">Sensors</h1>
                <div className="row row-cols-1 row-cols-md-2 g-4">
                    {
                        this.state.sensors.map(
                            sensor =>
                                <div key={sensor.id} className="col">
                                    <div className="card">
                                        <div className="card-body">
                                            <a href={`/sensors/${sensor.id}`} className="card-link">
                                                <h5 className="card-title">{sensor.id}</h5>
                                            </a>
                                            <p className="card-text">{sensor.value}</p>
                                        </div>
                                        <div className="card-footer">
                                            <li><small>registrationDate = {sensor.registrationDate}</small></li>
                                        </div>
                                    </div>
                                </div>
                        )
                    }
                </div>
            </div>
        )
    }

}

export default SensorsComponent
