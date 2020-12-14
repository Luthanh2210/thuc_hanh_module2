import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Function function = new Function();
        int cases = 0;
        do {
            System.out.println("CHƯƠNG TRÌNH QUẢN LÝ DANH BẠ ");
            System.out.println("Chọn chức năng theo số (để tiếp tục)");
            System.out.println("1 : Xem danh sách");
            System.out.println("2 : Thêm mới");
            System.out.println("3 : Cập nhật");
            System.out.println("4 : Xóa");
            System.out.println("5 : Tìm kiếm ");
            System.out.println("6 : Đọc từ file ");
            System.out.println("7 : Ghi vào file ");
            System.out.println("8 : Thoát ");
            try {
                cases = Integer.parseInt(sc.nextLine());
                switch (cases) {
                    case 1:
                        function.show();
                        break;
                    case 2:
                        function.addInfos();
                        break;
                    case 3:
                        function.edit();
                        break;
                    case 4:
                        function.delete();
                        break;
                    case 5:
                        function.search();
                    case 6:
                        function.readFile();
                    case 7:
                        function.writeToFile();
                }
            }catch (Exception e ){
                System.out.println("Xin hãy nhập lại ");
            }
        } while (cases != 8);
    }

}
