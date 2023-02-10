import React, { Component } from 'react'
import { Formik, Form, Field, ErrorMessage } from 'formik'
import CoachDataService from '../../api/todo/CoachoDataService'
import AuthenticationService from './AuthenticationService'


class CoachComponent extends Component{
    constructor(props){
        super(props)
        this.state = {
            id: this.props.param.id,
            firstName: this.props.params.firstName,
            lastName: this.props.params.lastName,
            middleName: this.props.params.middleName,
            dob: this.props.params.dob,
            email: this.props.params.email,
            password: this.props.params.password,
            image: this.props.params.image,
            teachingSince: this.props.params.teachingSince,
            rank: this.props.params.rank,
            description: this.props.params.description
        }
        this.onSubmit = this.onSubmit.bind(this)
        this.validate = this.validate.bind(this)
    }

    componentDidMount(){
        if(this.state.id === -1) {return}
        let username = AuthenticationService.getLoggedInUserName()
        CoachDataService.retrieveCoach(this.state.id)
        .then(response => this.setState({
            description : response.data.description,
            targetDate : moment(new Date()).format('YYYY-MM-DD')
        }))
    }




    render(){
        let {id, firstName, lastName, middleName, image, teachingSince, rank} = this.state
        return <div>
            <h1>Coach</h1>
            <div className="container">
                <Formik
                    initialValues={{ description, targetDate }}
                    onSubmit={this.onSubmit}
                    validateOnChange={false}
                    validateOnBlur={false}
                    validate={this.validate}
                    enableReinitialize={true}
                >
                    {
                        (props) => (
                            <Form>
                                <ErrorMessage name='description' component="div" className="alert alert-warning"/>

                                <ErrorMessage name='targetDate' component="div" className="alert alert-warning"/>

                                <fieldset className="form-group">
                                    <label>Description</label>
                                        <Field className="form-control" type="text" name="description"/>
                                </fieldset>

                                <fieldset className="form-group">
                                <label>Target Date</label>
                                        <Field className="form-control" type="date" name="targetDate"/>
                                </fieldset>

                                <button className='btn btn-success' type='submit'>Save</button>
                             </Form>)
                    }
                </Formik>
            </div>
        </div>
    }


}

export default CoachComponent