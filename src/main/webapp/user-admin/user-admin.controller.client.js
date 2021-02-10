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

var tableBody = jQuery("tbody")

var userArrayDummy = [
    {username: 'lovelace.a', password: String.fromCharCode(160), firstName: 'Ada', lastName: 'Lovelace', role: 'FACULTY'},
    {username: 'liddell.a', password: String.fromCharCode(160), firstName: 'Alice', lastName: 'Liddell', role: 'STUDENT'},
    {username: 'salehi.s', password: String.fromCharCode(160), firstName: 'Sina', lastName: 'Salehi', role: 'ADMIN'}
]

var updateButton = jQuery(".wbdv-button-update")

function addUser(table, userArray, user) {
    userArray.push(user)
    renderUsers(table, userArray)
}

addUser(tableBody, userArrayDummy, {username: 'lovelace.a', password: String.fromCharCode(160), firstName: 'Ada', lastName: 'Lovelace', role: 'FACULTY'})

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
    jQuery(".wbdv-button-remove").click(function (event) {
        var removeButton = jQuery(event.target)
        var rBID = parseInt(removeButton.attr("id").slice(-1))
        userArray.splice(rBID, 1)
        renderUsers(table, userArray)
    })
}

renderUsers(tableBody, userArrayDummy)

var $usernameField = $(".wbdv-field-username")
var $passwordField = $(".wbdv-field-password")
var $firstNameField = $(".wbdv-field-firstName")
var $lastNameField = $(".wbdv-field-lastName")
var $roleField = $(".wbdv-field-role")

var $createButton = $(".wbdv-button-create")
$createButton.click(function () {
    var newUser = {
        username: $usernameField.val(),
        password: $passwordField.val(),
        firstName: $firstNameField.val(),
        lastName: $lastNameField.val(),
        role: $roleField.val()
    }
    addUser(tableBody, userArrayDummy, newUser)
    $usernameField.val("")
    $passwordField.val("")
    $firstNameField.val("")
    $lastNameField.val("")
    $roleField.val("FACULTY")
})