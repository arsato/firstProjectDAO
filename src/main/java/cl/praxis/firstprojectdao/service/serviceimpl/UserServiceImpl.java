package cl.praxis.firstprojectdao.service.serviceimpl;

import cl.praxis.firstprojectdao.dao.UserDAO;
import cl.praxis.firstprojectdao.dao.daoimpl.UserDAOImpl;
import cl.praxis.firstprojectdao.model.UserDTO;
import cl.praxis.firstprojectdao.service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {

    private final UserDAO objUserDao;

    public UserServiceImpl() {
        this.objUserDao = new UserDAOImpl() {
        };
    }

    @Override
    public UserDTO selectUser(int id) {
        return objUserDao.selectUser(id);
    }

    @Override
    public List<UserDTO> selectAllUsers() {
        return objUserDao.selectAllUsers();
    }

    @Override
    public List<UserDTO> selectAllMostOne() {
        List<UserDTO> users = objUserDao.selectAllUsers();
        users.remove(users.size() - 1);
        return users;
    }

    @Override
    public UserDTO deactivateUser(UserDTO user) {
        UserDTO findUser = objUserDao.selectUser(user.getUserId());
        findUser.setIsActive(0);
        return objUserDao.updateUser(findUser);
    }

    @Override
    public UserDTO activateUser(UserDTO user) {
        UserDTO findUser = objUserDao.selectUser(user.getUserId());
        findUser.setIsActive(1);
        return objUserDao.updateUser(findUser);
    }

    @Override
    public UserDTO insertUser(UserDTO user) {
        return objUserDao.insertUser(user);
    }

    @Override
    public UserDTO updateUser(UserDTO user) {
        return objUserDao.updateUser(user);
    }

    @Override
    public boolean deleteUser(int id) {
        return objUserDao.deleteUser(id);
    }
}
