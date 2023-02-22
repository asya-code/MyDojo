import React, {Component} from "react"
import CoachDataService from './CoachDataService'
import moment from "moment"

class ListCoachesComponent extends Component{
    constructor(props){
        super(props)
        this.state = {
            coaches: [],
            message: null
        }
        this.deleteCoachClicked = this.deleteCoachClicked.bind(this)
        this.refreshCoachesList = this.refreshCoachesList.bind(this)
        this.updateCoachClicked = this.updateCoachClicked.bind(this)
        this.addCoachClicked = this.addCoachClicked.bind(this)
    }

    componentWillUnmount(){
        console.log('componentWillUnmount')
    }

    shouldComponentUpdate(nextProps, nextState){
        console.log('shouldComponentUpdate')
        console.log(nextProps)
        console.log(nextState)
        return true
    }

    componentDidMount(){
        console.log('componentDidMount')
        this.refreshCoachesList()
    }

    refreshCoachesList(){
        console.log("Refresh called")
        CoachDataService.retrieveAllCoaches()
        .then(
            response => {
                console.log(response)
                this.setState({coaches : response.data})
            }
        )
    }

    addCoachClicked(){
        this.props.navigate('/coaches/registerCoach')
    }

    updateCoachClicked(coachId){
        this.props.navigate(`/coaches/${coachId}`)
    }

    deleteCoachClicked(coachId){
        CoachDataService.deleteCoach(coachId)
        .then(
            response => {
                this.setState({message: `Delete of Coach ${coachId} successful`});
                this.refreshCoachesList();
            }
        )
    }

    render(){
        return(
            <div>
                <h1>Our Coaches</h1>
                <div className="container">
                    <ul className="public-list">
                            {
                                this.state.coaches.map(
                                    coach =>
                                       <li> 
                                        <div class="row" key={coach.coachId}>
                                            <div className="column">
                                                <h3 className="coachName">{coach.firstName} {coach.lastName}</h3>
                                                <h6> {coach.rank}</h6>
                                                <h6> Teaching since {coach.teachingSince}</h6>
                                                <div>{coach.description}</div>
                                            </div>
                                            
                                            <div className="column">
                                                <img src={coach.image}/>
                                            </div>
                                        </div>
                                        <br></br>
                                    </li>
                                    

                                )
                            }
                    </ul>
                </div>
            </div>
        )
    }
    }

export default ListCoachesComponent