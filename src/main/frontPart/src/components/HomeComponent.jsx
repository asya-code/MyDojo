import React, {Component} from "react"
import '../styles.css'

class HomeComponent extends Component{
    render(){
        return(
            <>
            <h1>Come train at the home of champions!</h1>
            <br></br>
            <div class="row">
                <div className="column">
                    <h5>We offer classes for kids and adults in: </h5>
                    <br></br>
                        <p>Kodokan Judo</p>
                        <p>Kodonkan Jiu-jitsu/Kosen Judo</p>
                        <p> Brasilian Jiu-jitsu </p>
            
                </div>
                <div className="column">
                <h5> NEW Adult Kodenkan Jujitsu classes Mondays and Wednesdays at 6pm!</h5>
                </div>
            </div>
            <img src='http://www.dawave.com/images/cahillcoaches05.jpg?crc=380288676'></img>
            </>
        )
    }
}
export default HomeComponent