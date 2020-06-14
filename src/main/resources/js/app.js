const React = require('react');
const ReactDOM = require('react-dom');
const client = require('./client');

var root = "/data"

class Profile extends React.Component{
	render() {
		return (
			<tr>
				<td>{this.props.profile.id}</td>
				<td>{this.props.profile.email}</td>
				<td>{this.props.profile.name}</td>
				<td>{this.props.profile.passwordHash}</td>
			</tr>
		)
	}
}

class ProfileList extends React.Component{
	render() {
		const profiles = this.props.profiles.map(profile =>
			<Profile key={profile.id} profile={profile}/>
		);
		return (
			<table>
				<tbody>
					<tr>
						<th>ID</th>
						<th>Email</th>
						<th>Name</th>
                        <th>PasswordHash</th>
					</tr>
					{profiles}
				</tbody>
			</table>
		)
	}
}

class App extends React.Component {

	constructor(props) {
		super(props);
		this.state = {profiles: []};
	}

	componentDidMount() { 
		this.loadFromServer(this.state.pageSize);
	}

	render() { 
		return (
			<ProfileList profiles={this.state.profiles}/>
		)
	}
	
	loadFromServer(pageSize) {
		follow(client, root, [
			{rel: 'profiles', params: {size: pageSize}}]
		).then(profileCollection => {
			return client({
				method: 'GET',
				path: profileCollection.entity._links.profile.href,
				headers: {'Accept': 'application/schema+json'}
			}).then(schema => {
				this.schema = schema.entity;
				return profileCollection;
			});
		}).done(profileCollection => {
			this.setState({
				profiles: profileCollection.entity._embedded.profiles,
				attributes: Object.keys(this.schema.properties),
				pageSize: pageSize,
				links: profileCollection.entity._links});
		});
	}
}

ReactDOM.render(
	<App />,
	document.getElementById('react')
)