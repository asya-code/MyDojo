import React, {Component} from "react";

class MyDojoApp extends Component{
    render(){
        const HeaderComponentWithNavigation = withNavigation(HeaderComponent);

        return(
            <div className="MyDojoApp">
                <Router>
                    <HeaderComponentWithNavigation/>

                </Router>
            </div>
        )
    }
}

export default MyDojoApp