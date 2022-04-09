import React from "react";
import {getSensorById} from "../services/SensorsService";

class SingleSensorComponent extends React.Component {
    constructor(props) {
        super();
        this.state = {
            id: props.match.params.id,
            sensor: null,
            error: null
        }
    }

    tick() {
        getSensorById(this.state.id).then((response) => {
            this.setState({
                error: null,
                sensor: response.data
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
        const sensor = this.state.sensor;
        const error = this.state.error;
        if (error){
            return <small>{error.data.error}</small>
        }
        if (!sensor){
            return <small>loading...</small>
        }

        return (
            <div>
                <h1 className="text-center">Sensor</h1>

                <div style={{marginRight: "10px", marginLeft: "10px"}} className="row row-cols-1 row-cols-md-1 g-4">
                    <div className="col">
                        <div className="card">
                            <div className="card-body">
                                <h5 className="card-title">id = {sensor.id}</h5>
                                <p className="card-body">value = {sensor.value}</p>
                            </div>
                            <div className="card-footer">
                                <small className="text-muted">
                                    registrationDate = {sensor.registrationDate}
                                </small>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default SingleSensorComponent
