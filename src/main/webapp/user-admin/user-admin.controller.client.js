// Controller Variables

var $usernameField // Text Field for Entering Username
var $passwordField // Text Field for Entering Password
var $firstNameField // Text Field for Entering First Name
var $lastNameField // Text Field for Entering Last Name
var $roleField // Dropdown Selection Menu for Selecting Role
var $tableBody // Table Body of User Table
var $createButton // Button for Creating New User
var $updateButton // Button for Updating Attributes of Existing User
var $removeButton // Button for Removing Existing User
var $editButton // Button for Selecting Existing User for Updating Attributes
var allUsersArray // Array of All Users
var selectedUser // Currently Selected User (via Edit Button)
var userService // Service for Interacting with Server

// Create User Function

/*
Re-designed from Professor Annunziato's code to be table-agnostic and array-agnostic
(user will be added to userArray and userArray will be rendered in table)
for greater flexibility
*/

function addUser(table, userArray, user) {
    userService.createUser(user).then(function (actualUser) {
        userArray.push(actualUser)
        renderUsers(table, userArray)
    })
}

// Update User Function

function updateUser() {
    selectedUser.username = $usernameField.val()
    selectedUser.password = $passwordField.val()
    selectedUser.firstName = $firstNameField.val()
    selectedUser.lastName = $lastNameField.val()
    selectedUser.role = $roleField.val()

    userService.updateUser(selectedUser._id, selectedUser).then(function (status) {
        var userIndex = allUsersArray.findIndex(user => user._id === selectedUser._id)
        allUsersArray[userIndex] = selectedUser
        renderUsers($tableBody, allUsersArray)
    })

    $usernameField.val("")
    $passwordField.val("")
    $firstNameField.val("")
    $lastNameField.val("")
    $roleField.val("FACULTY")
}

// Render Users Function

/*
Re-designed from Professor Annunziato's code to be table-agnostic (the users present in userArray
will be rendered in table) for greater flexibility
*/

function renderUsers(table, userArray) {

    table.empty() // Clear Existing Contents of table

    for (var i = 0; i < userArray.length; i++) {
        var user = userArray[i]

        table.prepend(`<tr class="wbdv-template wbdv-user wbdv-hidden">
                           <td class="wbdv-username">${user.username}</td>
                           <td>${user.password}</td>
                           <td class="wbdv-first-name">${user.firstName}</td>
                           <td class="wbdv-last-name">${user.lastName}</td>
                           <td class="wbdv-role">${user.role}</td>
                           <td class="wbdv-actions">
                               <span class="pull-right">
                                   <button class="btn btn-sm btn-outline-dark wbdv-button-remove"
                                           id="wbdv-button-remove-${i}">
                                       <i class="fa-2x fa fa-times wbdv-icon-remove"
                                          id="wbdv-icon-remove-${i}"> Remove
                                       </i>
                                   </button>
                                   <button class="btn btn-sm btn-outline-dark wbdv-button-edit"
                                           id="wbdv-button-edit-${user._id}">
                                       <i class="fa-2x fa fa-pencil wbdv-icon-edit"
                                          id="wbdv-icon-edit-${i}"> Edit
                                       </i>
                                   </button>
                               </span>
                           </td>
                       </tr>`)
    }

    // Remove Button and Remove User Function

    $(".wbdv-button-remove").click(function (event) {
        var removeButton = $(event.target)
        var rBIndex = parseInt(removeButton.attr("id").slice(-1))
        var rBID = userArray[rBIndex]._id

        userService.deleteUser(rBID).then(function (status) {
            userArray.splice(rBIndex, 1)
            renderUsers(table, userArray)
        })
    })

    // Edit Button and Edit User Function

    $(".wbdv-button-edit").click(function (event) {
        var editButton = $(event.target)
        var eBIndex = parseInt(editButton.attr("id").slice(-1))
        selectedUser = userArray[eBIndex]

        $usernameField.val(selectedUser.username)
        $passwordField.val(selectedUser.password)
        $firstNameField.val(selectedUser.firstName)
        $lastNameField.val(selectedUser.lastName)
        $roleField.val(selectedUser.role)
    })
}

// Main Function

function main() {

    // Initialize Controller Variables

    $usernameField = $(".wbdv-field-username")
    $passwordField = $(".wbdv-field-password")
    $firstNameField = $(".wbdv-field-firstName")
    $lastNameField = $(".wbdv-field-lastName")
    $roleField = $(".wbdv-field-role")
    $tableBody = $("tbody")
    $createButton = $(".wbdv-button-create")
    $updateButton = $(".wbdv-button-update")
    $removeButton = $(".wbdv-button-remove")
    $editButton = $(".wbdv-button-edit")
    allUsersArray = []
    selectedUser = null
    userService = new AdminUserServiceClient()

    // Create Button

    $createButton.click(function () {
        var newUser = {
            username: $usernameField.val(),
            password: $passwordField.val(),
            firstName: $firstNameField.val(),
            lastName: $lastNameField.val(),
            role: $roleField.val()
        }
        addUser($tableBody, allUsersArray, newUser)
        $usernameField.val("")
        $passwordField.val("")
        $firstNameField.val("")
        $lastNameField.val("")
        $roleField.val("FACULTY")
    })

    // Update Button

    $updateButton.click(updateUser)

    // Render All Existing Users from Server

    userService.findAllUsers().then(function (allUsers) {
        allUsersArray = allUsers
        renderUsers($tableBody, allUsersArray)
    })
}

$(main)