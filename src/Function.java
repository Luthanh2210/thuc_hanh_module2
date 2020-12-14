import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Function implements Display ,Serializable {
    Scanner sc = new Scanner(System.in);
    private ArrayList<PhoneBook> phoneBooks = new ArrayList<>();

    @Override
    public void show()  {
        int n = 0;
        do {
            System.out.println("Xin chọn :");
            System.out.println("1: Hiện thị");
            System.out.println("2: Thoát");
            try {
                n = Integer.parseInt(sc.nextLine());
                if (n == 1) {
                    for (PhoneBook phoneBook : phoneBooks) {
                        System.out.println(phoneBook.toString());
                    }
                }else{
                    System.out.println("Mời nhập lại");
                }
                break;
            } catch (Exception e) {
                System.out.println("Mời nhập lại");
            }
        } while (n != 2);
    }

    @Override
    public void addInfos() {
        PhoneBook phoneBook = new PhoneBook();
        int input = 0;
        do {
            System.out.println("Chọn chức năng ");
            System.out.println("1 : Nhập thông tin");
            System.out.println("2 : Thoát");
            try {
                input = Integer.parseInt(sc.nextLine());
                if (input == 1) {
                    phoneBook.addInfo();
                    phoneBooks.add(phoneBook);
                }
            } catch (NullPointerException | NumberFormatException e) {
                System.out.println("mời nhập lại ");
            }
        } while (input != 2);
    }


    @Override
    public void search() {
        int n = 0;
        do {
            System.out.println("Chọn Chức Năng");
            System.out.println("1 : Tìm");
            System.out.println("2 : Thoát ");
            try {
                n = Integer.parseInt(sc.nextLine());
                if (n == 1) {
                    System.out.println("Nhập Thông Tin Cần Tìm :");
                    String regex = sc.nextLine();
                    int index = 0;
                    Pattern pattern = Pattern.compile(regex);
                    Matcher matcher;
                    for (int i = 0; i < phoneBooks.size(); i++) {
                        matcher = pattern.matcher(phoneBooks.get(i).getName());
                        if (matcher.find()) {
                            System.out.println("STT " + i + " : " + phoneBooks.get(i).toString());
                            index++;
                        }
                    }
                    if (index <= 0) {
                        System.out.println("Tên này không có trong danh sách\n ");
                    }
                }
            } catch (Exception e) {
                System.out.println("Xin hãy nhập vào ");
            }
        } while (n != 2);
    }

    @Override
    public void edit() {
        int num = 0;
        do {
            System.out.println("Nhập thông tin cần sửa : ");
            System.out.println("Chọn chỉnh sửa theo : ");
            System.out.println("1 : Theo tên");
            System.out.println("2 : theo số điện thoại ");
            try {
                num = Integer.parseInt(sc.nextLine());
                String edit;
                int n = 0;
                switch (num) {
                    case 1:
                        System.out.println("Tên cần sửa :");
                        edit = sc.nextLine();
                        for (PhoneBook name : phoneBooks) {
                            if (edit.equals(name.getName())) {
                                System.out.println("Sửa tên : ");
                                String add = sc.nextLine();
                                name.setName(add);
                                System.out.println("Tên sau khi sửa " + name.getName());
                                n++;
                                break;
                            }
                        }
                        if (n == 0) {
                            System.out.println("Tên không co trong danh sách");
                            break;
                        }
                    case 2:
                        System.out.println("Nhập tên cần chỉnh lại số : ");
                        edit = sc.nextLine();
                        for (PhoneBook numberPhone : phoneBooks) {
                            if (edit.equals(numberPhone.getName())) {
                                System.out.println("chỉnh lại ");
                                String add = sc.nextLine();
                                numberPhone.setNumberPhone(add);
                                n++;
                                break;
                            }
                        }
                        if (n == 0) {
                            System.out.println("Tên ko có trong danh bạ");
                            break;
                        }
                        break;
                }
            } catch (Exception e) {
                System.out.println("Nhập lại");
            }
        } while (num != 3);
    }

    @Override
    public void delete() {
        int n = 0;
        do {
            System.out.println("1: Xóa");
            System.out.println("2: Thoát");
            try {
                n = Integer.parseInt(sc.nextLine());
                if (n == 1) {
                    System.out.println("Nhập tên cần xóa: ");
                    String id = sc.nextLine();
                    PhoneBook phoneBook = null;
                    for (PhoneBook book : phoneBooks) {
                        if (book.getName().equals(id)) {
                            phoneBook = book;
                            break;
                        }
                    }
                    if (phoneBook != null) {
                        System.out.println("Tên đã xóa là : \n" + phoneBook.getName());
                        phoneBooks.remove(phoneBook);
                    } else {
                        System.out.println("Không Có tên Trong Danh Sách");
                    }
                }
            } catch (Exception e) {
                System.out.println("Nhập sai rồi");
            }
        } while (n != 2);

    }
    public ArrayList<PhoneBook> getPhoneBooks() {
        return phoneBooks;
    }

    public void setPhoneBooks(ArrayList<PhoneBook> phoneBooks) {
        this.phoneBooks = phoneBooks;
    }


    private static final String COMMA_DELIMITER = ",";
    private static final String NEW_LINE_SEPARATOR = "\n";


    public void writeToFile() {
        String fileName = "contries.csv";
        writeCsvFile(fileName);
    }

    public  void writeCsvFile(String fileName) {
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(fileName);
            for (PhoneBook phoneBook : getPhoneBooks()) {
                fileWriter.append(phoneBook.getNumberPhone());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(phoneBook.getPhonebook());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(phoneBook.getName());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(phoneBook.getGender());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(phoneBook.getAddress());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(phoneBook.getDateOfBirth());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(phoneBook.getEmail());
                fileWriter.append(NEW_LINE_SEPARATOR);
            }

            System.out.println("CSV file was created successfully !!!");

        } catch (Exception e) {
            System.out.println("Error in CsvFileWriter !!!");
            e.printStackTrace();
        } finally {
            try {
                fileWriter.flush();
                fileWriter.close();
            } catch (IOException e) {
                System.out.println("Error while flushing/closing fileWriter !!!");
                e.printStackTrace();
            }
        }
    }



    public void readFile() {
        String line = null;
        FileReader fileReader = null;
        try {
            fileReader = new FileReader("contries.csv");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        assert fileReader != null;
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        while (true) {
            try {
                if ((line = bufferedReader.readLine()) == null) break;
            } catch (IOException exception) {
                System.out.println(exception);
            }
            assert line != null;
            String[] temp = line.split(COMMA_DELIMITER);
            String numberPhone = temp[0];
            String phoneBook = temp[1];
            String name = temp[2];
            String sex = temp[3];
            String address = temp[4];
            String dateOfBirth = temp[5];
            String email = temp[6];
            getPhoneBooks().add(new PhoneBook(name, numberPhone, address, email, dateOfBirth,phoneBook,sex));
        }
        try {
            bufferedReader.close();
        } catch (IOException exception) {
            exception.printStackTrace();
        }
        for (PhoneBook p : getPhoneBooks()) {
            System.out.println(p.toString());
        }
    }


}
