import React, {Component} from "react"
import TournamentDataService from "./TournamentDataService"
import moment from "moment"

class ListTournamentsComponent extends Component{
    constructor(props){
        super(props)
        this.state = {
            tournaments: [],
            message: null
        }
        this.deleteTournamentClicked = this.deleteTournamentClicked.bind(this)
        this.refreshTournamentsList = this.refreshTournamentsList.bind(this)
        this.updateTournamentClicked = this.updateTournamentClicked.bind(this)
        this.addTournamentClicked = this.addTournamentClicked.bind(this)
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
        this.refreshTournamentsList()
    }

    refreshTournamentsList(){
        console.log("Refresh called")
        TournamentDataService.retrieveAllTournaments()
        .then(
            response => {
                console.log(response)
                this.setState({tournaments : response.data})
            }
        )
    }

    addTournamentClicked(){
        this.props.navigate('/tournament/new')
    }

    updateTournamentClicked(tournamentId){
        this.props.navigate(`/tournaments/${tournamentId}`)
    }

    deleteTournamentClicked(tournamentId){
        TournamentDataService.deleteTournamentClicked(tournamentId)
        .then(
            response => {
                this.setState({message: `Delete of Tournament ${tournamentId} successful`});
                this.refreshTournamentsList();
            }
        )
    }

    render(){
        return(
            <div>
                <h1>Tournaments</h1>
                <div className="container">
                <span className="add-student-btn">
                    <button className="btn btn-success btn-sm" onClick={this.addStudentClicked}> Add Tournament</button>
                </span>
                <table className="public-list">
                    <tbody>
                        {
                            this.state.tournaments.map(
                                tournament =>
                                <li>
                                <div class="row" key={tournament.tournamentId}>
                                    <h3>{tournament.tournamentName}</h3>
                                    <h5>{tournament.art} {tournament.age}</h5>
                                    <div>
                                        <h6>Date: {tournament.date}   Time: {tournament.time}</h6>
                                        </div>
                                    <div>{tournament.description}</div>
                                    <img src="https://cf-images.us-east-1.prod.boltdns.net/v1/static/6057994453001/5727f920-e19c-4354-ae84-8f8778b475c8/53eae407-80a2-4d12-aef5-1cab69de493b/1280x720/match/image.jpg"></img>
                                </div>
                                </li>
                            )
                        }
                    </tbody>
                </table>
                </div>
            </div>
        )
    }
    }

export default ListTournamentsComponent