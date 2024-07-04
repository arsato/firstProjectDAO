package cl.praxis.firstprojectdao.dao;

import cl.praxis.firstprojectdao.model.UserDTO;

import java.util.List;

public interface UserDAO {

    public UserDTO selectUser(int id);

    public List<UserDTO> selectAllUsers();

    public UserDTO insertUser(UserDTO user);

    public UserDTO updateUser(UserDTO user);

    public boolean deleteUser(int id);
}
