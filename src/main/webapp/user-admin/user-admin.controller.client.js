/*(function () {
    var $usernameFld, $passwordFld;
    var $firstNameFld, $lastNameFld, $roleFld;
    var $removeBtn, $editBtn, $createBtn;
    var $userRowTemplate, $tbody;
    var userService = new AdminUserServiceClient();
    $(main);

    function main() { … }
    function createUser() { … }
    function deleteUser() { … }
    function selectUser() { … }
    function updateUser() { … }
    function renderUsers(users) { … }
    function findAllUsers() { … } // optional - might not need this
    function findUserById() { … } // optional - might not need this
})()*/

var $usernameField
var $passwordField
var $firstNameField
var $lastNameField
var $roleField
var $tableBody
var $createButton
var $updateButton
var userArrayDummy
var userService = new AdminUserServiceClient()

function addUser(table, userArray, user) {
    userArray.push(user)
    renderUsers(table, userArray)
}

function renderUsers(table, userArray) {
    table.empty()
    for (var i = 0; i < userArray.length; i++) {
        var user = userArray[i]
        table.prepend(`<tr class="wbdv-template wbdv-user wbdv-hidden">
                           <td class="wbdv-username">${user.username}</td>
                           <td>${user.password}</td>
                           <td class="wbdv-first-name">${user.firstName}</td>
                           <td class="wbdv-last-name">${user.lastName}</td>
                           <td class="wbdv-role">${user.role}</td>
                           <td class="wbdv-actions"><span class="pull-right">
                               <button class="btn btn-outline-dark wbdv-button-remove" id="wbdv-button-remove-${i}"><i class="fa-2x fa fa-times wbdv-icon-remove" id="wbdv-icon-remove-${i}"> Remove</i></button>
                               <button class="btn btn-outline-dark wbdv-button-edit" id="wbdv-button-edit-${i}"><i class="fa-2x fa fa-pencil wbdv-icon-edit" id="wbdv-icon-edit-${i}"> Edit</i></button>
                           </span></td>
                       </tr>`)
    }
    $(".wbdv-button-remove").click(function (event) {
        var removeButton = $(event.target)
        var rBID = parseInt(removeButton.attr("id").slice(-1))
        userArray.splice(rBID, 1)
        renderUsers(table, userArray)
    })
}

function main() {
    $usernameField = $(".wbdv-field-username")
    $passwordField = $(".wbdv-field-password")
    $firstNameField = $(".wbdv-field-firstName")
    $lastNameField = $(".wbdv-field-lastName")
    $roleField = $(".wbdv-field-role")
    $tableBody = $("tbody")
    $createButton = $(".wbdv-button-create")
    $updateButton = $(".wbdv-button-update")
    userArrayDummy = []

    $createButton.click(function () {
        var newUser = {
            username: $usernameField.val(),
            password: $passwordField.val(),
            firstName: $firstNameField.val(),
            lastName: $lastNameField.val(),
            role: $roleField.val()
        }
        addUser($tableBody, userArrayDummy, newUser)
        $usernameField.val("")
        $passwordField.val("")
        $firstNameField.val("")
        $lastNameField.val("")
        $roleField.val("FACULTY")
    })

    userService.findAllUsers()
}

$(main)