package hello.hellospring.domain;

public class Member {

    private Long id;
    private String name;

    // Member ID
    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    // Member Name
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
