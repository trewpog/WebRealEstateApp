package real_estate.model.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.*;

import org.hibernate.annotations.ForeignKey;


@Entity
@Table (name="user")
public class User implements Serializable {
    
    private static final long serialVersionUID =  1L;
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="id_user", nullable=false)
    private Integer idUser;
    @Column (name="name", nullable = false, length = 80 )
    private String name;
    @Column (name="email", nullable = false, length = 80 )
    private String email;
    @Column (name="phone", nullable = false, length = 15 )//(034)-8888-8888
    private String phone;
    @Column (name="date_birth", nullable = false)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateBirth;
    @Column (name="date_register", nullable = false)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateRegister;
        
    @Column(name = "username", unique=true, length = 25)
    private String username;
    @Column(name = "password", length = 40)
    private String password;
    @Column(name = "permission", length = 36)
    private String permission;
    
    @OneToOne(mappedBy = "user", fetch = FetchType.LAZY)
    @ForeignKey(name="address_user_key")
    private Address address;
    
    @ManyToOne(optional=false)
    @ForeignKey(name = "user_gender_key")
    @JoinColumn(name="id_gender", referencedColumnName = "id_gender")
    private Gender gender;

    @ManyToOne(optional=false)
    @ForeignKey(name = "user_type_user_key")
    @JoinColumn(name="id_type_user", referencedColumnName = "id_type_user")
    private TypeUser typeUser;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    @ForeignKey(name = "id_user")
    private List<Property> properties;

    @OneToOne(optional=true, fetch= FetchType.LAZY)
    @ForeignKey(name="sale_user_key")
    private Sale sale;


    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    @ForeignKey(name="log_user_key")
    private List<Log> logs;


    public User() {
        this.gender = new Gender();
        this.typeUser = new TypeUser();
    }

    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getDateBirth() {
        return dateBirth;
    }

    public void setDateBirth(Date dateBirth) {
        this.dateBirth = dateBirth;
    }

    public Date getDateRegister() {
        return dateRegister;
    }

    public void setDateRegister(Date dateRegister) {
        this.dateRegister = dateRegister;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }
         
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + (this.idUser != null ? this.idUser.hashCode() : 0);
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
        final User other = (User) obj;
        if (this.idUser != other.idUser && (this.idUser == null || !this.idUser.equals(other.idUser))) {
            return false;
        }
        return true;
    }

    public TypeUser getTypeUser() {
        return typeUser;
    }

    public void setTypeUser(TypeUser typeUser) {
        this.typeUser = typeUser;
    }

    public List<Property> getProperties() {
        return properties;
    }

    public void setProperties(List<Property> properties) {
        this.properties = properties;
    }

    public Sale getSale() {
        return sale;
    }

    public void setSale(Sale sale) {
        this.sale = sale;
    }

    public List<Log> getLogs() {
        return logs;
    }

    public void setLogs(List<Log> logs) {
        this.logs = logs;
    }
}
