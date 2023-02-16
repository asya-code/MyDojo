import React, { Component } from 'react'
import { Formik, Form, Field, ErrorMessage } from 'formik'
import StudentDataService from './StudentDataService'
import AuthenticationService from './AuthenticationService'
import moment from 'moment'


class StudentComponent extends Component{
    constructor(props){
        super(props)
        this.state = {
            studentId: this.props.param.studentId,
            firstName: this.props.params.firstName,
            lastName: this.props.params.lastName,
            middleName: this.props.params.middleName,
            dob: this.props.params.dob,
            email: this.props.params.email,
            password: this.props.params.password,
            image: this.props.params.image,
            started: this.props.params.started,
            rank: this.props.params.rank,
        }
        this.onSubmit = this.onSubmit.bind(this)
        this.validate = this.validate.bind(this)
    }

    componentDidMount(){
        //if(this.state.studentId === -1) {return}
        //let username = AuthenticationService.getLoggedInUserName()
        StudentDataService.retrieveStudent(this.state.id)
        .then(response => this.setState({
            studentId: this.props.param.studentId,
            firstName: this.props.params.firstName,
            lastName: this.props.params.lastName,
            middleName: this.props.params.middleName,
            dob: this.props.params.dob,
            email: this.props.params.email,
            password: this.props.params.password,
            image: this.props.params.image,
            started: this.props.params.started,
            rank: this.props.params.rank,
        }))
    }
    validate(values){
        let errors ={}

        if(!values.firstName){
            errors.firstName = 'First Name is required'
        }

        if(!values.lastName){
            errors.lastName = 'Last Name is required'
        }

        if(!values.dob){
            errors.dob = 'Date of Birth is required'
        }

        if(!moment(values.targetDate).isValid()) {
            errors.targetDate = 'Enter valid date of birth'
        }

        if(!values.email){
            errors.email = 'Email is required'
        }

        if(!values.password){
            errors.password = 'Password is required'
        }

        return errors
    }
    onSubmit(values){
        //let username = AuthenticationService.getLoggedInUserName()
        // if (this.state.id == null){
        //     let tempId = null
        // } else {let tempId = this.state.id}
    
        let student = {
            studentId : this.state.studentId,
            firstName: values.firstName,
            lastName: values.params.lastName,
            middleName: values.params.middleName,
            dob: values.params.dob,
            email: values.params.email,
            password: values.params.password,
            image: values.params.image,
            started: values.params.started,
            rank: values.params.rank,
        }

        if (this.state.id === null) { 
            StudentDataService.addStudent(student)
                .then(
                    () => this.props.navigate('/students')
                )   
        }
        else {
            StudentDataService.updateStudent(this.state.studentId, student)
                .then(
                    () => this.props.navigate('/students')
            )
        }
    }


    render(){
        let {studentId, firstName, lastName, middleName, dob, email, 
            password, image, started, rank} = this.state
        return <div>
            <h1>Student</h1>
            <div className="container">
                <Formik
                    initialValues={{ studentId, firstName, lastName, middleName, 
                        dob, email, password, image, started, rank }}
                    onSubmit={this.onSubmit}
                    validateOnChange={false}
                    validateOnBlur={false}
                    validate={this.validate}
                    enableReinitialize={true}
                >
                    {
                        (props) => (
                            <Form>
                                <ErrorMessage name='name' component="div" className="alert alert-warning"/>

                                <ErrorMessage name='dob' component="div" className="alert alert-warning"/>

                                <fieldset className="form-group">
                                    <label>First Name</label>
                                        <Field className="form-control" type="text" name="firstName"/>
                                </fieldset>

                                <fieldset className="form-group">
                                <label>Last Date</label>
                                        <Field className="form-control" type="text" name="lastName"/>
                                </fieldset>

                                <fieldset className="form-group">
                                    <label>Middle Name</label>
                                        <Field className="form-control" type="text" name="middletName"/>
                                </fieldset>

                                <fieldset className="form-group">
                                <label>DOB</label>
                                        <Field className="form-control" type="date" name="targetdobDate"/>
                                </fieldset>

                                <fieldset className="form-group">
                                <label>email</label>
                                        <Field className="form-control" type="email" name="email" pattern=".+@globex\.com" size="30" required/>
                                </fieldset>

                                <fieldset className="form-group">
                                    <label>imagee</label>
                                        <Field className="form-control" type="text" name="image"/>
                                </fieldset>

                                <fieldset className="form-group">
                                <label>started</label>
                                        <Field className="form-control" type="date" name="started"/>
                                </fieldset>

                                <fieldset className="form-group">
                                <label>rank</label>
                                        <Field className="form-control" type="text" name="rank"/>
                                </fieldset>

                                <button className='btn btn-success' type='submit'>Save</button>
                             </Form>)
                    }
                </Formik>
            </div>
        </div>
    }


}

export default StudentComponent