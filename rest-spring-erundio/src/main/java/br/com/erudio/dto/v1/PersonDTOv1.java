package br.com.erudio.dto.v1;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.web.bind.annotation.Mapping;

import java.io.Serializable;
import java.util.Objects;

@JsonPropertyOrder({"id", "first_name", "last_name", "address", "gender"})
// @JsonPropertyOrder = ordem em que quero que o JSON seja gerado
public class PersonDTOv1 extends RepresentationModel<PersonDTOv1> implements Serializable {

    @JsonProperty("id")
    private Long key;

    @JsonProperty("first_name")
    // @JsonProperty = nome que quero que seja gerado no JSON
    private String firstName;
    @JsonProperty("last_name")

    private String lastName;
    private String address;

//    @JsonIgnore
    // @JsonIgnore = esse atributo será omitido do JSON
    private String gender;

    public PersonDTOv1() {
    }

    public PersonDTOv1(Long key, String firstName, String lastName, String address, String gender) {
        this.key = key;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.gender = gender;
    }

    public Long getKey() {
        return key;
    }

    public void setKey(Long key) {
        this.key = key;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        PersonDTOv1 that = (PersonDTOv1) o;
        return Objects.equals(key, that.key) && Objects.equals(firstName, that.firstName) && Objects.equals(lastName, that.lastName) && Objects.equals(address, that.address) && Objects.equals(gender, that.gender);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), key, firstName, lastName, address, gender);
    }

    @Override
    public String toString() {
        return "PersonDTOv1{" +
                "key=" + key +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address='" + address + '\'' +
                ", gender='" + gender + '\'' +
                "} " + super.toString();
    }
}
