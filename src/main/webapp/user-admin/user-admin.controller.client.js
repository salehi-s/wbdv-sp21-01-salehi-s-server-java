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

var userDummy = {username: 'dummy.u', password: String.fromCharCode(160), firstName: 'User', lastName: 'Dummy', role: 'STUDENT'}

var createButton = jQuery(".wbdv-button-create")
createButton.click(function () {addUser(tableBody, userArrayDummy, userDummy)})

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
                               <button class="btn btn-outline-dark wbdv-button-remove" id="${i}"><i class="fa-2x fa fa-times wbdv-remove"> Remove</i></button>
                               <button class="btn btn-outline-dark wbdv-button-edit"><i class="fa-2x fa fa-pencil wbdv-edit"> Edit</i></button>
                           </span></td>
                       </tr>`)
    }
    jQuery(".wbdv-remove").click(function (event) {
        console.log(event.target)
        var removeButton = jQuery(event.target)
        var rBClass = removeButton.attr("class")
        console.log(rBClass)
    })
}

renderUsers(tableBody, userArrayDummy)