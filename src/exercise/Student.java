package exercise;

import java.util.Objects;

public class Student
{
    int id;
    String name;

    public Student(int id, String name)
    {
        this.name = name;
        this.id = id;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return id == student.id && Objects.equals(name, student.name);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(id, name);
    }

    @Override
    public String toString()
    {
        return "{" + id + name + '}';
    }
}
