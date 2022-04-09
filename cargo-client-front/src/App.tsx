import React from "react";
import './App.css';
import Routes from "./components/Routes";
import HeaderComponent from "./components/HeaderComponent";
import {BrowserRouter as Router} from "react-router-dom"
import FooterComponent from "./components/FooterComponent";
import {AuthProvider} from "./context/AuthContext";

function App() {

    return (
        <div className="App">
            <AuthProvider>
                <HeaderComponent/>
                <Router>
                    <Routes/>
                </Router>
                <FooterComponent/>
            </AuthProvider>
        </div>
    );
}

export default App;
