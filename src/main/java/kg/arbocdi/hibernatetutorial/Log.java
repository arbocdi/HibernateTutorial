package kg.arbocdi.hibernatetutorial;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Data;
import lombok.ToString;

/**
 *
 * @author arbocdi
 */
@Entity
@Table(name = "logs", schema = "company")
@Data
public class Log implements Serializable {

    @Id
    @GeneratedValue
    private int id;
    //private int action_id;
    //private int user_id;
    private String descr;
    @Column(insertable = false,updatable = false)
    private int action_id;
    @Column(insertable = false,updatable = false)
    private int user_id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "action_id", referencedColumnName = "id")
    private Action action;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

}
