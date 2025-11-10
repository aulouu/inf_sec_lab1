package itmo.aulouu.inf.sec.lab1.service;

import itmo.aulouu.inf.sec.lab1.entity.Role;
import itmo.aulouu.inf.sec.lab1.entity.User;
import itmo.aulouu.inf.sec.lab1.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@AllArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;

    /**
     * Подтвердить права пользователя на роль администратора
     */
    @Transactional(rollbackFor = Exception.class)
    public void approveUser(String username) {
        User user = getByUsername(username);
        if (getCurrentUser().getRole() != Role.ADMIN)
            throw new IllegalArgumentException("У вас нет прав на выполнение этого действия");
        if (user.getRole() == Role.ADMIN) throw new IllegalArgumentException("User is already an administrator");

        user.setRole(Role.ADMIN);
        userRepository.save(user);
    }

    /**
     * Сохранение пользователя
     *
     * @return сохраненный пользователь
     */
    @Transactional(rollbackFor = Exception.class)
    public User save(User user) {
        return userRepository.save(user);
    }

    /**
     * Создание пользователя
     *
     * @return созданный пользователь
     */
    @Transactional(rollbackFor = Exception.class)
    public User create(User user) {
        if (userRepository.findByUsername(user.getUsername()) != null) {
            throw new EntityNotFoundException("Пользователь с таким именем уже существует");
        }
        return save(user);
    }

    /**
     * Получение пользователя по имени пользователя
     *
     * @return пользователь
     */
    @Transactional(readOnly = true)
    public User getByUsername(String username) {
        User user = userRepository.findByUsername(username);
        if (user == null) throw new EntityNotFoundException("Пользователь не найден");
        return user;
    }

    /**
     * Получение пользователя по имени пользователя
     * <p>
     * Нужен для Spring Security
     *
     * @return пользователь
     */
    public UserDetailsService userDetailsService() {
        return this::getByUsername;
    }

    /**
     * Получение текущего пользователя
     *
     * @return текущий пользователь
     */
    public User getCurrentUser() {
        var username = SecurityContextHolder.getContext().getAuthentication().getName();
        return getByUsername(username);
    }
}
