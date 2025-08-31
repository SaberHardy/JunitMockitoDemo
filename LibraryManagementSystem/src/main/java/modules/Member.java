package modules;

import java.time.LocalDate;

public class Member {
    private int id;
    private String memberId;
    private String name;
    private String email;
    private String phone;
    private LocalDate membershipDate;

    public Member(int id, String memberId, String email, String name, String phone, LocalDate membershipDate) {
        this.id = id;
        this.memberId = memberId;
        this.email = email;
        this.name = name;
        this.phone = phone;
        this.membershipDate = membershipDate;
    }

    public Member(String memberId, String name, String email, String phone, LocalDate membershipDate) {
        this.memberId = memberId;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.membershipDate = membershipDate;
    }

    public Member() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
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

    public LocalDate getMembershipDate() {
        return membershipDate;
    }

    public void setMembershipDate(LocalDate membershipDate) {
        this.membershipDate = membershipDate;
    }

    public Boolean isMembershipActive() {
        return membershipDate.plusYears(1).isAfter(LocalDate.now());
    }
}
