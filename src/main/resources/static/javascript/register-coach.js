const registerForm = document.getElementById('coach-register-form')
const registerEmail = document.getElementById('register-email')
const registerPassword = document.getElementById('register-password')
const firstName = document.document.getElementById('first-name')
const lastName = document.document.getElementById('last-name')
const middleName = document.document.getElementById('middle-name')
const dob = document.document.getElementById('dob')
const teachingSince = document.document.getElementById('teaching-since')
const rank = document.document.getElementById('rank')
const lastName = document.document.getElementById('last-name')
const lastName = document.document.getElementById('last-name')

const baseUrl = 'http://localhost:8080/'

const handleSubmit = async (e) => {
    e.preventDefault()


// file handler needed
    let newCoach = {
        "firstName": firstName.value,
        "lastName" :  lastName.value,
        "middleName": middleName.value,
        "dob" : dob.value,
        "email" : registerEmail.value,
        "password" : registerPassword.value,
        "image" : null,
        "teachingSince" : teachingSince.value,
        "rank": rank.value,
        "lessonDtoSet" : null,
        "tournamentDtoSet" : null
    }
    const response = await fetch(`${baseUrl}/register-coach`, {
        method: 'POST',
        body: JSON.stringify(newCoach),
        headers: {
            'Content-type': 'application/json'
            }
        })
        .catch(err => console.error(err.message))
    const responseArr = await response.json()

    if (response.status === 200){
        window.location.replace(responseArr[0])
        }
}

registerForm.addEventListener("submit", handleSubmit)
