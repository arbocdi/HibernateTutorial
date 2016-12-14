package kg.arbocdi.hibernatetutorial;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Data;
import lombok.ToString;

@Entity
@Table(name="actions",schema = "company")
@Data
public class Action implements Serializable {
    @Id
    private int id;
    private String descr;
    @OneToMany(mappedBy = "action")
    private List<Log> logs;

    @Override
    public String toString() {
        return "Action{" + "id=" + id + ", descr=" + descr + '}';
    }
    
    
    
}
