
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class MatrixLayerRotation {

    // Complete the matrixRotation function below.
    static void matrixRotation(List<List<Integer>> matrix, int r) {
        try {
        
            int row  = matrix.size()-1;
            int coulumn = matrix.get(0).size()-1;
            int startXindex = 0;
            int startYindex = 0;
            
        while(startXindex <= row){
            
            ArrayList<Point> inder = getindextoswap(startXindex,startYindex , row, coulumn);

            int arraySise = inder.size();
            int getfinalPlace = 0;
            int i = 0;
            Integer valueTOStore = Integer.MAX_VALUE;
            Integer valuetoCopy = Integer.MAX_VALUE;
            
            HashSet<Integer> valuehasbenProcess = new HashSet<Integer>();
            while (i < arraySise) {
                
                if(valuetoCopy == Integer.MAX_VALUE)
                    valuetoCopy = matrix.get(inder.get(getfinalPlace).getX()).get(inder.get(getfinalPlace).getY());
                else
                    valuetoCopy = valueTOStore ;

                valuehasbenProcess.add(getfinalPlace);

                getfinalPlace = getnextPlace( getfinalPlace , r , arraySise );

                valueTOStore = matrix.get(inder.get(getfinalPlace).getX()).get(inder.get(getfinalPlace).getY());

                matrix.get(inder.get(getfinalPlace).getX()).set(inder.get(getfinalPlace).getY() ,valuetoCopy);
                
                if(valuehasbenProcess.contains(getfinalPlace)){
                    getfinalPlace = giveUnprocessPlace(valuehasbenProcess , arraySise );
                     valuetoCopy = Integer.MAX_VALUE;
                }

                i++;
            }
            
            startXindex++;
            startYindex++;
            row--;
            coulumn--;
        }
        
        
        for (int i = 0; i < matrix.size(); i++) {
         System.out.println(matrix.get(i).toString().replaceAll("[|\\]|,|\\[|]", ""));
        }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static int giveUnprocessPlace(HashSet<Integer> valuehasbenProcess,
            int arraySise) {
        
        for (int i = 0; i < arraySise; i++) {
            if(!valuehasbenProcess.contains(i))
                return i;
        }
    
        return 0; 
    }

    private static int getnextPlace(int i, int r, int arraySise) {

        for (int j = r; j > 0; j--) {
               --i;
            if(i < 0){
                i = arraySise-1;
            }
        }
        return i;
    }

    private static ArrayList<Point> getindextoswap(int startXindex, int startYindex,
            int row, int coulumn) {
        
        ArrayList<Point> arrayList = new ArrayList<Point>();
        
        for (int i = startXindex; i <= coulumn; i++) {
            Point point = new Point(startXindex, i);
            arrayList.add(point);
        }
        
        for (int i = (startXindex+1); i <= row; i++) {
            Point point = new Point(i, coulumn);
            arrayList.add(point);
        }
        
        for (int i = (coulumn-1); i >= startYindex; i--) {
            Point point = new Point(row ,i );
            arrayList.add(point);
        }
        
        for (int i = (row-1); i > startXindex; i--) {
            Point point = new Point( i, startYindex);
            arrayList.add(point);
        }
        
        return arrayList;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] mnr = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int m = Integer.parseInt(mnr[0]);

        int n = Integer.parseInt(mnr[1]);

        int r = Integer.parseInt(mnr[2]);

        List<List<Integer>> matrix = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            String[] matrixRowTempItems = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

            List<Integer> matrixRowItems = new ArrayList<>();

            for (int j = 0; j < n; j++) {
                int matrixItem = Integer.parseInt(matrixRowTempItems[j]);
                matrixRowItems.add(matrixItem);
            }

            matrix.add(matrixRowItems);
        }

        matrixRotation(matrix, r);

        bufferedReader.close();
    }
    
    static  class  Point {
    @Override
        public String toString() {
            return "Point [x=" + x + ", y=" + y + "]";
        }

    int x;
    int y;

    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    
    Point(int x , int y){
        this.x = x ;
        this.y = y;
    }
}
}
