package hello.Models;

public class OfficesDTO {
    private int id;

    private Integer country;

    private String title;

    private String phone;

    private String contact;

    public OfficesDTO(int id, int country, String title, String phone, String contact) {
        this.id = id;
        this.country = country;
        this.title = title;
        this.phone = phone;
        this.contact = contact;
    }

    public OfficesDTO() {
    }

    public int getId() {
        return id;
    }

    public Integer getCountry() {
        return country;
    }

    public String getTitle() {
        return title;
    }

    public String getPhone() {
        return phone;
    }

    public String getContact() {
        return contact;
    }
}
