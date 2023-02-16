import React, {Component} from "react"
import LessonDataService from './LessonDataService'
import moment from "moment"

class ListLessonsComponent extends Component{
    constructor(props){
        super(props)
        this.state = {
            lessons: [],
            message: null
        }
        this.deleteLessonClicked = this.deleteLessonClicked.bind(this)
        this.refreshLessonsList = this.refreshLessonsList.bind(this)
        this.updateLessonClicked = this.updateLessonClicked.bind(this)
        this.addLessonClicked = this.addLessonClicked.bind(this)
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
        this.refreshLessonsList()
    }

    refreshLessonsList(){
        console.log("Refresh called")
        LessonDataService.retrieveAllLessons()
        .then(
            response => {
                console.log(response)
                this.setState({lessons : response.data})
            }
        )
    }

    addLessonClicked(){
        this.props.navigate('/classes/-1')
    }

    updateLessonClicked(lessonId){
        this.props.navigate(`/classes/${lessonId}`)
    }

    deleteLessonClicked(lessonId){
        LessonDataService.deleteLesson(lessonId)
        .then(
            response => {
                this.setState({message: `Delete of Lesson ${lessonId} successful`});
                this.refreshLessonsList();
            }
        )
    }

    render(){
        return(
            <div>
                <h1>Classes</h1>
                <div className="container">
                <table className="public-list">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Class</th>
                        <th>Martial Art</th>
                        <th>Day</th>
                        <th>Time</th>
                        <th>Description </th>
                        <th>Update</th>
                        <th>Delete</th>
                    </tr>
                </thead>
                    <tbody>
                        {
                            this.state.lessons.map(
                                lesson =>
                                <tr key={lesson.lessonId}>
                                    <td>{lesson.lessonId}</td>
                                    <td>{lesson.lessonName}</td>
                                    <td>{lesson.art}</td>
                                    <td>{lesson.day}</td>
                                    <td>{lesson.time}</td>
                                    <td>{lesson.description}</td>
                                    {/* <td>{lesson.coaches}</td> */}
                                    <td><button className="btn btn-success btn-sm update-btn" onClick={() => this.updateLessonClicked(lesson.lessonId)}> Update </button></td>
                                    <td><button className="btn btn-danger btn-sm delete-btn" onClick={() => this.deleteLessonClicked(lesson.lessonId)}> Delete </button></td>                             
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

export default ListLessonsComponent