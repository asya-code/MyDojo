import React, { Component } from 'react'
import { Formik, Form, Field, ErrorMessage } from 'formik'
import LessonDataService from '../../api/todo/LessonDataService'
//import AuthenticationService from './AuthenticationService'


class LessonComponent extends Component{
    constructor(props){
        super(props)
        this.state = {
            id: this.props.param.id,
            lessonName: this.props.params.lessonName,
            art: this.props.params.art,
            day: this.props.params.day,
            time: this.props.params.time,
            description: this.props.params.description
        }
        this.onSubmit = this.onSubmit.bind(this)
        this.validate = this.validate.bind(this)
    }

    componentDidMount(){
        // if(this.state.id === -1) {return}
        LessonDataService.retrieveAllLessons()
        .then(response => this.setState({
            id: this.props.param.id,
            lessonName: this.props.params.lessonName,
            art: this.props.params.art,
            day: this.props.params.day,
            time: this.props.params.time,
            description: this.props.params.description
        }))
    }

    render(){
        let {id, lessonName, art, day, time, description} = this.state
        return <div>
            <h1>Class</h1>
            <div className="container">
                <Formik
                    initialValues={{ id, lessonName, art, day, time, description }}
                    onSubmit={this.onSubmit}
                    validateOnChange={false}
                    validateOnBlur={false}
                    validate={this.validate}
                    enableReinitialize={true}
                >
                    {
                        (props) => (
                            <Form>
                                <ErrorMessage name='lessonName' component="div" className="alert alert-warning"/>

                                <ErrorMessage name='day' component="div" className="alert alert-warning"/>

                                <ErrorMessage name='time' component="div" className="alert alert-warning"/>

                                <fieldset className="form-group">
                                    <label>Class name</label>
                                        <Field className="form-control" type="text" name="className"/>
                                </fieldset>

                                <fieldset className="form-group">
                                <label>Art</label>
                                        <Field className="form-control" type="text" name="art"/>
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

export default LessonComponent