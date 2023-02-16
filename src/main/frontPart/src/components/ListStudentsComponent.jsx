import React, {Component} from "react";
import StudentDataService from "./StudentDataService";
import moment from "moment"

class ListStudentsComponent extends Component{
    constructor(props){
        super(props)
        this.state = {
            students: [],
            message: null
        }
        this.deleteStudentClicked = this.deleteStudentClicked.bind(this)
        this.refreshStudentsList = this.refreshStudentsList.bind(this)
        this.updateStudentClicked = this.updateStudentClicked.bind(this)
        this.addStudentClicked = this.addStudentClicked.bind(this)
    }

    componentWillUnmount() {
        console.log('componentWillUnmount')
    }

    shouldComponentUpdate(nextProps, nextState) {
        console.log('shouldComponentUpdate')
        console.log(nextProps)
        console.log(nextState)
        return true
    }

    componentDidMount(){
        this.refreshStudentsList()
    }

    refreshStudentsList(){
        StudentDataService.retrieveAllStudents()
        .then(
            response => {
                console.log(response)
                this.setState({students : response.data})
            }
        )
    }

    addStudentClicked(){
        this.props.navigate('/students/new-student')
    }

    updateStudentClicked(studentId){
        this.props.navigate(`/students/${studentId}`)
    }

    deleteStudentClicked(studentId){
        StudentDataService.deleteStudent(studentId)
        .then(
            response => {
                this.setState({message : `Delete of Student ${studentId} successful`})
                this.refreshStudentsList()
            }
        )
    }

    render() {
        return(
            <div>
            <h1>Students</h1>
            <div className="container">
            <span className="add-student-btn">
                <button className="btn btn-success btn-sm" onClick={this.addStudentClicked}> Add Student</button>
            </span>
                <table className="admin-list">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>First Name</th>
                        <th>Last Name</th>
                        <th>Middle Name</th>
                        <th>rank</th>
                        <th>started </th>
                        <th>DOB</th>
                        <th>email</th>
                        <th>Update</th>
                        <th>Delete</th>
                    </tr>
                </thead>
                <tbody>
                        {
                            this.state.students.map(
                                student =>
                                <tr key={student.studentId}>
                                    <td>{student.studentId}</td>
                                    <td>{student.firstName}</td>
                                    <td>{student.lastName}</td>
                                    <td>{student.middleName}</td>
                                    <td>{student.rank}</td>
                                    <td>{moment(student.started).format('MM/DD/YYYY')}</td>
                                    <td>{moment(student.dob).format('MM/DD/YYYY')}</td>
                                    <td>{student.email}</td>
                                    {/* <td><button className="btn btn-success btn-sm update-btn" onClick={this.updateStudentClicked(student.studentId)}> Update </button></td>
                                    <td><button className="btn btn-danger btn-sm delete-btn" onClick={this.deleteStudentClicked(student.studentId)}> Delete </button></td>                             
                                    */}
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

export default ListStudentsComponent