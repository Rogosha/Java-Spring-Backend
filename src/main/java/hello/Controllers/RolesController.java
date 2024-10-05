package hello.Controllers;

import hello.Models.Roles;
import hello.Repositories.RolesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class RolesController {

    @Autowired
    private RolesRepository rolesRepository;

    @CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.PUT, RequestMethod.DELETE,  RequestMethod.POST, RequestMethod.OPTIONS})
    @GetMapping("/roles")
    public Iterable<Roles> getRoles() {
        Iterable<Roles> roles = rolesRepository.findAll();
        return roles;
    }

    @CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.PUT, RequestMethod.DELETE,  RequestMethod.POST, RequestMethod.OPTIONS})
    @GetMapping("/roles/{id}")
    public Optional<Roles> getRole(@PathVariable(value = "id") int id) {
        Optional<Roles> role = rolesRepository.findById(id);
        return role;
    }

  /*  @PostMapping("/roles")
    public Integer postOffice(
            @RequestParam(name = "Title") String title) {

        Roles role = new Roles(title);
        rolesRepository.save(role);
        return role.getId();
    }

    @PutMapping("/roles/{id}")
    public String putOffice(
            @PathVariable(value = "id") int id,
            @RequestParam(name = "Title", required = false) String title) {
        try {
            Roles role = rolesRepository.findById(id).orElseThrow();
            if (title == null) {
                title = role.getTitle();
            }
            role.setTitle(title);
            rolesRepository.save(role);
            return "OK";
        } catch (Exception e) {
            return "NOT_OK";
        }
    }

    @DeleteMapping("/roles/{id}")
    public String deleteRole(
            @PathVariable(value = "id") int id) {
        try {
            Roles role = rolesRepository.findById(id).orElseThrow();
            rolesRepository.delete(role);
            return "OK";
        } catch (Exception e) {
            return "NOT_OK";
        }
    } */
}
