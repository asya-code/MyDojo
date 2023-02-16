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
                <table className="public-table">
                    <tbody>
                        {
                            this.state.tournaments.map(
                                tournament =>
                                <tr key={tournament.tournamentId}>
                                    <td>{tournament.tournamentName}</td>
                                    <td>{tournament.art}</td>
                                    <td>{tournament.age}</td>
                                    <td>{tournament.day}</td>
                                    <td>{tournament.time}</td>
                                    <td>{tournament.description}</td>
                                    {/* <td>{tournament.coaches}</td> */}
                                </tr>
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