package real_estate.model.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.ForeignKey;
import javax.persistence.*;

@Entity
@Table(name="gender")
public class Gender implements Serializable {
    
    private static final long serialVersionUID =  1L;   
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="id_gender",nullable=false)
    private Integer idGender;
    @Column(name="description", unique=true, nullable=false, length=9)
    private String description;

    @OneToMany(mappedBy = "gender", fetch = FetchType.LAZY)
    @ForeignKey(name = "user_gender_key")
    private List<User> users;
    
    public Gender() {
    }

    public Integer getIdGender() {
        return idGender;
    }

    public void setIdGender(Integer idGender) {
        this.idGender = idGender;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> pessoas) {
        this.users = pessoas;
    }
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + (this.idGender != null ? this.idGender.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Gender other = (Gender) obj;
        if (this.idGender != other.idGender && (this.idGender == null || !this.idGender.equals(other.idGender))) {
            return false;
        }
        return true;
    }
    
}
