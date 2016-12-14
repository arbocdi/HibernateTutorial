package kg.arbocdi.hibernatetutorial;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Data;

/**
 *
 * @author arbocdi
 */
@Entity
@Table(name = "users", schema = "company")
@Data
public class User implements Serializable {

    @Id
    @GeneratedValue
    private int id;
    private String name;
    private String pw;
    @OneToMany(mappedBy = "user")
    private List<Log> logs;

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", name=" + name + ", pw=" + pw + '}';
    }
    
    

}
