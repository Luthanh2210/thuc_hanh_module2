import java.io.Serializable;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneBook implements Serializable {
    private String numberPhone;
    private String group;
    private String name;
    private String gender;
    private String address;
    private String DateOfBirth;
    private String Email;

    public PhoneBook() {
    }

    public PhoneBook(String numberPhone, String group, String name, String gender, String address, String dateOfBirth, String email) {
        this.numberPhone = numberPhone;
        this.group = group;
        this.name = name;
        this.gender = gender;
        this.address = address;
        this.DateOfBirth = dateOfBirth;
        this.Email = email;
    }

    public String getNumberPhone() {
        return numberPhone;
    }

    public void setNumberPhone(String numberPhone) {
        this.numberPhone = numberPhone;
    }

    public String getPhonebook() {
        return group;
    }

    public void setPhonebook(String phonebook) {
        this.group = phonebook;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String sex) {
        this.gender = sex;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDateOfBirth() {
        return DateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        DateOfBirth = dateOfBirth;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }


    @Override
    public String toString() {
        return "PhoneBook{" +
                "numberPhone='" + numberPhone + '\'' +
                ", Group='" + group + '\'' +
                ", name='" + name + '\'' +
                ", sex='" + gender + '\'' +
                ", address='" + address + '\'' +
                ", DateOfBirth='" + DateOfBirth + '\'' +
                ", Email='" + Email + '\'' +
                '}';
    }

    public void addInfo() {
        Scanner sc = new Scanner(System.in);
        boolean check = false;
        do {
            System.out.println("Nhập sđt:");
            String line = sc.nextLine();
            Pattern pattern = Pattern.compile("^\\d{10}$");
            Matcher matcher = pattern.matcher(line);
            if (matcher.find()) {
                check = true;
                numberPhone = line;
            } else {
                System.out.println("Vui Lòng Không Để Trống");
            }
        }while (!check);

        System.out.println("Nhập nhóm: ");
        group = sc.nextLine();
        System.out.println("Nhập tên:");
        name = sc.nextLine();
        System.out.println("Nhập giới tính: ");
        gender = sc.nextLine();
        System.out.println("Nhập địa chỉ: ");
        address = sc.nextLine();
        System.out.println("Nhập ngày tháng năm sinh: ");
        DateOfBirth = sc.nextLine();

        boolean check1 = false;
        do {
            System.out.println("Nhập địa chỉ email: ");
            String s = "^[A-Za-z0-9+_.-]+@(.+)$";
            String line = sc.nextLine();
            Pattern pattern = Pattern.compile(s);
            Matcher matcher = pattern.matcher(line);
            if (matcher.find()) {
                check1 = true;
                Email = line;
            } else {
                System.out.println("Vui Lòng Không Để Trống");
            }
        }while (!check1);

    }
}

