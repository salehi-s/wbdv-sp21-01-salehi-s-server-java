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

var users = [
    {username: 'lovelace.a', password: String.fromCharCode(160), firstName: 'Ada', lastName: 'Lovelace', role: 'FACULTY'},
    {username: 'liddell.a', password: String.fromCharCode(160), firstName: 'Alice', lastName: 'Liddell', role: 'STUDENT'},
    {username: 'salehi.s', password: String.fromCharCode(160), firstName: 'Sina', lastName: 'Salehi', role: 'ADMIN'}
]

var tableBody = jQuery("tbody")

function renderUsers(table, users) {
    for (var i = 0; i < users.length; i++) {
        var user = users[i]
        table.append(`<tr className="wbdv-template wbdv-user wbdv-hidden">
                              <td className="wbdv-username">${user.username}</td>
                              <td>${user.password}</td>
                              <td className="wbdv-first-name">${user.firstName}</td>
                              <td className="wbdv-last-name">${user.lastName}</td>
                              <td className="wbdv-role">${user.role}</td>
                              <td className="wbdv-actions"><span className="pull-right">
                                  <button className="btn btn-outline-dark"><i className="fa-2x fa fa-times wbdv-remove"> Remove</i></button>
                                  <button className="btn btn-outline-dark"><i className="fa-2x fa fa-pencil wbdv-edit"> Edit</i></button>
                              </span></td>
                          </tr>`)
    }
}

renderUsers(tableBody, users)