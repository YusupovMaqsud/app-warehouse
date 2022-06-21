package uz.pdp.appwarehouse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uz.pdp.appwarehouse.entity.Product;
import uz.pdp.appwarehouse.entity.User;
import uz.pdp.appwarehouse.payload.ProductDto;
import uz.pdp.appwarehouse.payload.Result;
import uz.pdp.appwarehouse.payload.UserDto;
import uz.pdp.appwarehouse.service.ProductService;
import uz.pdp.appwarehouse.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("adduser")
    public Result addUser(@RequestBody UserDto userDto){
        Result result = userService.addUser(userDto);
        return result;
    }



    @GetMapping("/getuser")
    public List<User> getUsers(){
        List<User> userList = userService.getUsers();
        return userList;
    }



    @GetMapping("/getuser/{id}")
    public Result getUser(@PathVariable Integer id){
        Result user = userService.getUser(id);
        return user;
    }



    @DeleteMapping("/deleteuser/{id}")
    public Result deleteUser(@PathVariable Integer id){
        Result result = userService.deleteUser(id);
        return result;
    }



    @PutMapping("/edituser/{id}")
    public Result editUser(@RequestBody UserDto userDto, Integer id){
        Result result = userService.editUser(userDto, id);
        return result;
    }
}
