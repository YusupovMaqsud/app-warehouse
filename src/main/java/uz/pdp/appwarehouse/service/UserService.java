package uz.pdp.appwarehouse.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import uz.pdp.appwarehouse.entity.*;
import uz.pdp.appwarehouse.payload.ProductDto;
import uz.pdp.appwarehouse.payload.Result;
import uz.pdp.appwarehouse.payload.UserDto;
import uz.pdp.appwarehouse.repository.*;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    WarehouseRepository warehouseRepository;

    public Result addUser(UserDto userDto) {
        boolean exists = userRepository.existsByFirstNameAndLastNameAndWarehouses_id(userDto.getFirstName(), userDto.getLastName(), userDto.getWarhouseId());
        if (exists)
            return new Result("Bunday User mavjud", false);


        Optional<Warehouse> optionalWarehouse = warehouseRepository.findById(userDto.getWarhouseId());
        if (!optionalWarehouse.isPresent()) {
            return new Result("Bunday Ombor mavjud emas", false);
        }

        User user = new User();
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setPhoneNumber(userDto.getPhoneNumber());
        user.setCode(UUID.randomUUID().toString());
        user.setPassword(userDto.getPassword());
        user.setWarehouses((Set<Warehouse>) optionalWarehouse.get());
        userRepository.save(user);

        return new Result("User saqlandi", true);
    }


    public List<User> getUsers() {
        List<User> userList = userRepository.findAll();
        return userList;
    }


    public Result getUser(@PathVariable Integer id) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (!optionalUser.isPresent())
            return new Result("Bunday User mavjud emas", false);
        User user = optionalUser.get();
        return new Result("Bunday User mavjud ", true, user);
    }


    public Result deleteUser(Integer id) {
       userRepository.deleteById(id);
        return new Result("User deleted ", true);
    }


    public Result editUser(UserDto userDto, Integer id) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (!optionalUser.isPresent())
            return new Result("Bunday User mavjud emas", false);

        Optional<Warehouse> optionalWarehouse = warehouseRepository.findById(userDto.getWarhouseId());
        if (!optionalWarehouse.isPresent())
            return new Result("Bunday Ombor mavjud emas", false);

        User user = optionalUser.get();
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setPhoneNumber(userDto.getPhoneNumber());
        user.setCode(UUID.randomUUID().toString());
        user.setPassword(userDto.getPassword());
        user.setWarehouses((Set<Warehouse>) optionalWarehouse.get());
        userRepository.save(user);
        return new Result("User edited", true);

    }
}
