import { useParams } from "react-router-dom";

function withParam(Component) {
    return props => <Component {...props} params={useParams()}/>;
}

export default withParam
