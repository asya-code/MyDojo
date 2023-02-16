import axios from "axios"

class TournamentDataService{
    retrieveAllTournaments(){
        console.log("retrieveAllTournaments called")
        return axios.get(`http://localhost:8080/api/tournaments/all`)
    }

    retrieveTournament(tournamentId){
        return axios.get(`http://localhost:8080/api/tournaments/${tournamentId}`)
    }

    addTournament(tournament) {
        return axios.post(`http://localhost:8080/api/tournaments/new-tournament`, tournament)
    }

    updateTournament(tournamentId, tournament){
        return axios.put(`http://localhost:8080/api/tournaments/${tournamentId}`, tournament)
    }

    deleteTournament(tournamentId){
        return axios.delete(`http://localhost:8080/api/tournaments/${tournamentId}`)
    }
    
}

export default new TournamentDataService()