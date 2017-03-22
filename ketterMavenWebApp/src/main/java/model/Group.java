package model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by bramd on 20-3-2017.
 */
@Entity
@Table(name = "groups")
public class Group implements Serializable
{
    @Id
    private String groupName;

    @ManyToMany
    @JoinTable(name="user_group",
            joinColumns = @JoinColumn(name = "groupname",
                    referencedColumnName = "groupname"),
            inverseJoinColumns = @JoinColumn(name = "username",
                    referencedColumnName = "username"))
    private List<User> users;

    public Group() {
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
