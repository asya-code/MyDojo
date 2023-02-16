import React, { Component } from 'react'
import { Formik, Form, Field, ErrorMessage } from 'formik'
import TournamentDataService from './TournamentDataService'
//import AuthenticationService from './AuthenticationService'


class TournamentComponent extends Component{
    constructor(props){
        super(props)
        this.state = {
            id: this.props.param.id,
            tournamentName: this.props.params.tournamentName,
            art: this.props.params.art,
            age: this.props.params.age,
            day: this.props.params.day,
            time: this.props.params.time,
            description: this.props.params.description
        }
        this.onSubmit = this.onSubmit.bind(this)
        this.validate = this.validate.bind(this)
    }

    componentDidMount(){
        // if(this.state.id === -1) {return}
        TournamentDataService.retrieveAllTournaments()
        .then(response => this.setState({
            id: this.props.param.id,
            tournamentName: this.props.params.tournamentName,
            art: this.props.params.art,
            age: this.props.params.age,
            day: this.props.params.day,
            time: this.props.params.time,
            description: this.props.params.description
        }))
    }

    render(){
        let {id, tournamentName, art, age, day, time, description} = this.state
        return <div>
            <h1>Tournaments</h1>
            <div className="container">
                <Formik
                    initialValues={{ id, tournamentName, art, age, day, time, description }}
                    onSubmit={this.onSubmit}
                    validateOnChange={false}
                    validateOnBlur={false}
                    validate={this.validate}
                    enableReinitialize={true}
                >
                    {
                        (props) => (
                            <Form>
                                <ErrorMessage name='tournamentName' component="div" className="alert alert-warning"/>

                                <ErrorMessage name='day' component="div" className="alert alert-warning"/>

                                <ErrorMessage name='time' component="div" className="alert alert-warning"/>

                                <fieldset className="form-group">
                                    <label>Tournament name</label>
                                        <Field className="form-control" type="text" name="className"/>
                                </fieldset>

                                <fieldset className="form-group">
                                <label>Art</label>
                                        <Field className="form-control" type="text" name="art"/>
                                </fieldset>

                                <fieldset className="form-group">
                                <label>Age</label>
                                        <Field className="form-control" type="text" name="age"/>
                                </fieldset>

                                <fieldset className="form-group">
                                <label>Day</label>
                                        <Field className="form-control" type="text" name="day"/>
                                </fieldset>

                                <fieldset className="form-group">
                                <label>Time</label>
                                        <Field className="form-control" type="text" name="time"/>
                                </fieldset>

                                <fieldset className="form-group">
                                <label>Description</label>
                                        <Field className="form-control" type="text" name="sescription"/>
                                </fieldset>

                                <button className='btn btn-success' type='submit'>Save</button>
                             </Form>)
                    }
                </Formik>
            </div>
        </div>
    }


}

export default TournamentComponent