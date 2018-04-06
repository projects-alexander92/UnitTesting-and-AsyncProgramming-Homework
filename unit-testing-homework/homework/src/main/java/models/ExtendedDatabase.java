package models;

import javax.naming.OperationNotSupportedException;
import java.util.HashSet;
import java.util.Set;

public class ExtendedDatabase extends Database
{
    private Set<User> people;

    public ExtendedDatabase()
    {
        super();
        this.people = new HashSet<>();
    }

    public ExtendedDatabase(Integer... args)
    {
        super(args);
        this.people = new HashSet<>();
    }

    @Override
    public void addElement(Integer element) throws OperationNotSupportedException
    {
        super.addElement(element);
    }

    @Override
    public void removeElement() throws OperationNotSupportedException
    {
        super.removeElement();
    }

    @Override
    public Integer[] getStorage()
    {
        return super.getStorage();
    }

    public void addPerson(User user) throws OperationNotSupportedException
    {
        Long id = user.getId();
        if (id == null || id < 0)
        {
            throw new OperationNotSupportedException("Invalid id");
        }
        String username = user.getUsername();
        boolean exists = this.people.stream().anyMatch(e -> e.getId().equals(id) || e.getUsername().equals(username));
        if (exists)
        {
            throw new OperationNotSupportedException("User allrdy Exists");
        }
        this.people.add(user);
    }

    public User findByUserName(String username) throws OperationNotSupportedException
    {
        if (username == null)
        {
            throw new OperationNotSupportedException("Username param cannot be null");
        }
        for (User person : people)
        {
            if (person.getUsername().equals(username))
            {
                return person;
            }
        }
        throw new OperationNotSupportedException("No such Username in DB");
    }

    public User findById(long id) throws OperationNotSupportedException
    {
        for (User person : people)
        {
            if (person.getId().equals(id))
            {
                return person;
            }
        }
        throw new OperationNotSupportedException("No such Id in DB");
    }

    public void remove(User user)
    {
        for (User person : this.people)
        {
            if (person.getId().equals(user.getId()))
            {
                this.people.remove(person);
            }
        }
    }

    public Set<User> getPeople()
    {
        return this.people;
    }
}
