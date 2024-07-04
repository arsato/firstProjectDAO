package cl.praxis.firstprojectdao.service;

import cl.praxis.firstprojectdao.model.UserDTO;

import java.util.List;

public interface UserService {

    public UserDTO selectUser(int id);

    public List<UserDTO> selectAllUsers();

    public UserDTO insertUser(UserDTO user);

    public UserDTO updateUser(UserDTO user);

    public boolean deleteUser(int id);
}
