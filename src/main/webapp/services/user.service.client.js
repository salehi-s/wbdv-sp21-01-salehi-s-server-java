/*
Function AdminUserServiceClient() is used to initialize a new user service variable
in the user-admin controller
*/

function AdminUserServiceClient() {
    this.createUser = createUser
    this.findAllUsers = findAllUsers
    this.deleteUser = deleteUser
    this.updateUser = updateUser
    this.url = 'https://wbdv-generic-server.herokuapp.com/api/salehi.s/users' // Server URL
    var self = this

    // Send a new user to the server

    function createUser(user) {
        return fetch(self.url, {
            method: 'POST',
            headers: {
                'content-type': 'application/json'
            },
            body: JSON.stringify(user)
        }).then(function (response) {
            return response.json()
        })
    }

    // Find all existing users in the server

    function findAllUsers() {
        return fetch(self.url).then(function (response) {
            return response.json()
        })
    }

    // Update the attributes of an existing user in the server

    function updateUser(userId, user) {
        return fetch(`${self.url}/${userId}`, {
            method: 'PUT',
            headers: {
                'content-type': 'application/json'
            },
            body: JSON.stringify(user)
        }).then(response => response.json())
    }

    // Remove an existing user from the server

    function deleteUser(userId) {
        return fetch(`${self.url}/${userId}`, {method: 'DELETE'})
    }
}