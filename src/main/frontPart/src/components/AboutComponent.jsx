import React, {Component} from "react"
import '../styles.css'

class AboutComponent extends Component{
    render(){
        return(
            <>
            <h2>Cahill's Judo Academy:</h2>
            <h2>A Legendary Name in Martial Arts for over 70 years</h2>
            <br></br>
            <p>
                Cahill's Judo Academy was founded in 1948 by Professor John Cahill, 
                in South San Francisco. He was one of the first non-Japanese jujitsu students, 
                studying under Professor Henry S. Okazaki at his dojo in Hawaii.
            </p>

            <p>
                Cahill went on to become a highly respected instructor in his own right 
                in Kodenkan Danzan Ryu Jujitsu, and Kodokan Judo. That tradition continues 
                today with his son Willy, who moved the dojo to San Bruno, where it is today.
            </p>

            <div class="row">
                <div className="column">
                    <img src="http://www.dawave.com/images/willy9dan64-crop-u12500.jpg?crc=494155539"></img>
                </div>
                <div className="column">
                    <img src='http://www.dawave.com/images/okazaki.jpg?crc=521132347'></img>
                </div>
            </div>

            <div class="row">
                <div className="column">
                    <p>
                        Willy Cahill has been an Olympic Judo coach, Paralympic Judo coach, 
                        Pan Am Games Judo coach, as well as coaching other regional and national 
                        judo teams and  judokas.
                    </p>

                    <p>
                        He was promoted to 9th degree black belt in Kodokan Judo, and 10th degree in 
                        Kodenkan Jujitsu, making him one of the highest ranking martial artists in the country.
                    </p>

                    <p>
                        Cahill's Judo Academy has produced several Olympians and nearly 1000 national and 
                        international champions.
                    </p>
                </div>
                <div className="column">
                    <img src='http://www.dawave.com/images/p1000371sm-crop-u13979.jpg?crc=3931121946'></img>
                </div>
            </div>
            <div>
                You can read more about Willy Cahil <a href="https://en.wikipedia.org/wiki/Willy_Cahill">on Wikipedia</a>
            </div>
            <div>
                and  <a href="https://www.cnn.com/videos/sports/2018/03/05/willy-cahill-9th-degree-black-belt-judo-82-year-old-judoka-judo-world-spc-intl.cnn">watch on CNN</a>
            </div>

            </>
        )
    }
}
export default AboutComponent