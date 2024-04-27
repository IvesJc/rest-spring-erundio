package br.com.erudio.dto.v1;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.io.Serializable;

@JsonPropertyOrder({"id", "first_name", "lastName", "address", "gender"})
// @JsonPropertyOrder = ordem em que quero que o JSON seja gerado
public class PersonDTOv1 implements Serializable {

    private Long id;

    @JsonProperty("first_name")
    // @JsonProperty = nome que quero que seja gerado no JSON
    private String firstName;
    private String lastName;
    private String address;

//    @JsonIgnore
    // @JsonIgnore = esse atributo será omitido do JSON
    private String gender;

    public PersonDTOv1() {
    }

    public PersonDTOv1(Long id, String firstName, String lastName, String address, String gender) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.gender = gender;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
}
