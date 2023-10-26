public class test {
    public static void main(String[] args) {
        int[] solution(int[][] arr) {
            List<Integer> a = new ArrayList<>();
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr[i].length; j++) {
                    a.add(arr[i][j]);
                }
            }
            List<Integer> b = new ArrayList<>();
            for (int i = 0; i < a.size(); i++) {
                int c = 0;
                for (int j = 1; j < a.get(i); j++) {
                    if (a.get(i) % j == 0) {
                        c++;
                    }
                }
                if (c < 2 && a.get(i) > 1 && b.indexOf(a.get(i))==-1) {
                    b.add(a.get(i));
                }
            }
            Collections.sort(b);
            return b;
        }
    }
}
