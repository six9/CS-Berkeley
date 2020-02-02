public class TriangleDrawer {
   public static void drawTriangle(int N) {
      int row = 0;
      while (row < N) {
         int col = 0;
         while (col <= row) {
            if (col == row) {
               System.out.println('*');
            } else {
            System.out.print('*');
            }
            col = col + 1;
         }
         row = row + 1;
      }
   }
   
   public static void main(String[] args) {
      drawTriangle(20);
   }
}
