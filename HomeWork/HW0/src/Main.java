public class Main {
    public static void main(String[] args) {
        int size = 5;
        for(int col = 1; col <= size; col++){
            for(int row = 1; row < col; row++){
                System.out.print('*');
            }
            System.out.println('*');
        }
    }
}