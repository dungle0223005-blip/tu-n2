
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package murach.data;

import murach.business.User;

public class UserDB {
    // demo lưu user, thật ra chỉ in ra console thôi
    public static int insert(User user) {
        System.out.println("Đã lưu user: "
            + user.getFirstName() + " "
            + user.getLastName()
            + " (" + user.getEmail() + ")");
        return 1; // giả sử luôn luôn thành công
    }
}
