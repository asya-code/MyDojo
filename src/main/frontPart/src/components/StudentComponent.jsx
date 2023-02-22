import React from 'react'
import { Formik, Form, Field, ErrorMessage } from 'formik'
// import StudentDataService from './StudentDataService'
import axios from "axios"
// import AuthenticationService from './AuthenticationService'
import moment from 'moment'


function StudentComponent2() {

    // const { firstName, lastName, middleName, dob, email,
    //     password, image, started, rank } = this.state

    const validate = (values) => {
        const errors = {}

        console.log(values);

        if (!values.firstName) {
            errors.firstName = 'First Name is required'
        }

        if (!values.lastName) {
            errors.lastName = 'Last Name is required'
        }

        if (!values.dob) {
            errors.dob = 'Date of Birth is required'
        }

        const dob = moment(values.dob).format('MM-DD-YYYY')
        if (!moment(dob).isValid()) {
            errors.dob = 'Enter valid date of birth'
        }

        if (!values.email) {
            errors.email = 'Email is required'
        }

        if (!values.password) {
            errors.password = 'Password is required'
        }

        return errors
    }

    const onSubmit = (values) => {
        console.log(values)

        const newStudent = {
            firstName: values.firstName,
            lastName: values.lastName,
            middleName: values.middleName,
            dob: moment(values.dob).format('MM-DD-YYYY'),
            email: values.email,
            password: values.password,
            image: values.image,
            started: values.started,
            rank: values.rank,
        }

        axios.post(`http://localhost:8080/api/students/registerStudent`, newStudent, {
            headers: {
                'Content-Type': 'application/json'
            }
        });

        // StudentDataService.addStudent(newStudent)
        //     .then((response) => {
        //         console.log(response);
        //     })
        //     .then(() => this.props.navigate('/students'))
        //     .catch(function (error) {
        //         console.log(error);
        //     });
    }

    return (
    <div>
        <h1>Student</h1>
        <div className="container">
            <Formik
                initialValues={{
                    firstName: '', lastName: '', middleName: '',
                    dob: '', email: '', password: '', image: '', started: '', rank: ''
                }}
                onSubmit={onSubmit}
            >
                        <Form>
                            {/* <ErrorMessage name='name' component="div" className="alert alert-warning" />

                            <ErrorMessage name='dob' component="div" className="alert alert-warning" /> */}

                            <fieldset className="form-group">
                                <label>First Name</label>
                                <Field className="form-control" type="text" name="firstName" id="firstName" />
                            </fieldset>

                            <fieldset className="form-group">
                                <label>Last Name</label>
                                <Field className="form-control" type="text" name="lastName" id="lastName" />
                            </fieldset>

                            <fieldset className="form-group">
                                <label>Middle Name</label>
                                <Field className="form-control" type="text" name="middleName" id="middleName" />
                            </fieldset>

                            <fieldset className="form-group">
                                <label>DOB</label>
                                <Field className="form-control" type="date" name="dob" id="dob" />
                            </fieldset>

                            <fieldset className="form-group">
                                <label>email</label>
                                        <Field className="form-control" type="email" name="email" id="email" />
                                </fieldset>

                            <fieldset className="form-group">
                                <label>image</label>
                                <Field className="form-control" type="text" name="image" id="image" />
                            </fieldset>

                            <fieldset className="form-group">
                                <label>started</label>
                                <Field className="form-control" type="date" name="started" id="started" />
                            </fieldset>

                            <fieldset className="form-group">
                                <label>rank</label>
                                <Field className="form-control" type="text" name="rank" id="rank" />
                            </fieldset>

                            <button className='btn btn-success' type='submit'>Save</button>
                        </Form>
            </Formik>
        </div>
    </div>
    );
}

export default StudentComponent2;

// class StudentComponent extends Component {
//     constructor(props){
//         super(props);
//         this.state = {
//             firstName: this.props.params.firstName || "",
//             lastName: this.props.params.lastName || "",
//             middleName: this.props.params.middleName || "",
//             dob: moment(this.props.params.dob).format('MM/DD/YYYY'),
//             email: this.props.params.email || "",
//             password: this.props.params.password || "",
//             image: this.props.params.image || "",
//             started: this.props.params.started || "",
//             rank: this.props.params.rank || "",
//         }
//         // this.onSubmit = this.onSubmit.bind(this)
//         // this.validate = this.validate.bind(this)
//     }

//     validate(values){
//         let errors ={}

//         if(!values.firstName){
//             errors.firstName = 'First Name is required'
//         }

//         if(!values.lastName){
//             errors.lastName = 'Last Name is required'
//         }

//         if(!values.dob){
//             errors.dob = 'Date of Birth is required'
//         }

//         if(!moment(values.dob).isValid()) {
//             errors.dob = 'Enter valid date of birth'
//         }

//         if(!values.email){
//             errors.email = 'Email is required'
//         }

//         if(!values.password){
//             errors.password = 'Password is required'
//         }

//         return errors
//     }

//     onSubmit (values) {
//         console.log(values)
//         const student = {
//             firstName: values.params.firstName,
//             lastName: values.params.lastName,
//             middleName: values.params.middleName,
//             dob: values.params.dob,
//             email: values.params.email,
//             password: values.params.password,
//             image: values.params.image,
//             started: values.params.started,
//             rank: values.params.rank,
//         }

//         StudentDataService.addStudent(student)
//             .then(() => this.props.navigate('/students'))
//     }

//     render(){
//         const {firstName, lastName, middleName, dob, email, 
//             password, image, started, rank} = this.state
//         return <div>
//             <h1>Student</h1>
//             <div className="container">
//                 <Formik
//                     initialValues={{firstName, lastName, middleName, 
//                         dob, email, password, image, started, rank }}
//                     onSubmit={this.onSubmit.bind(this)}
//                     validateOnChange={false}
//                     validateOnBlur={false}
//                     validate={this.validate.bind(this)}
//                     enableReinitialize={true}
//                 >
//                     {
//                         (props) => (
//                             <Form>
//                                 <ErrorMessage name='name' component="div" className="alert alert-warning"/>

//                                 <ErrorMessage name='dob' component="div" className="alert alert-warning"/>

//                                 <fieldset className="form-group">
//                                     <label>First Name</label>
//                                         <Field className="form-control" type="text" name="firstName"/>
//                                 </fieldset>

//                                 <fieldset className="form-group">

//                                 <label>Last Name</label>
//                                         <Field className="form-control" type="text" name="lastName"/>
//                                 </fieldset>

//                                 <fieldset className="form-group">
//                                     <label>Middle Name</label>
//                                         <Field className="form-control" type="text" name="middletName"/>
//                                 </fieldset>

//                                 <fieldset className="form-group">
//                                 <label>DOB</label>
//                                         <Field className="form-control" type="date" name="targetdobDate"/>
//                                 </fieldset>

//                                 {/* <fieldset className="form-group">
//                                 <label>email</label>
//                                         <Field className="form-control" type="email" name="email" pattern=".+@globex\.com" size="30" required/>
//                                 </fieldset> */}

//                                 <fieldset className="form-group">
//                                     <label>image</label>
//                                         <Field className="form-control" type="text" name="image"/>
//                                 </fieldset>

//                                 <fieldset className="form-group">
//                                 <label>started</label>
//                                         <Field className="form-control" type="date" name="started"/>
//                                 </fieldset>

//                                 <fieldset className="form-group">
//                                 <label>rank</label>
//                                         <Field className="form-control" type="text" name="rank"/>
//                                 </fieldset>

//                                 <button className='btn btn-success' type='submit'>Save</button>
//                              </Form>)
//                     }
//                 </Formik>
//             </div>
//         </div>
//     }


// }

// export default StudentComponent