class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        
        int[] result = new int[k];
        int[] count = new int[mat.length];
        for(int i = 0; i < mat.length; i++) {
            for(int j = 0; j < mat[0].length; j++) {
                if(mat[i][j] == 0) {
                    break;
                } else {
                    count[i]++;
                }
            }
        }
        int index = 0;
        while(k > 0) {
            int min = 0;
            for(int i = 0; i < mat.length; i++) {
                if(count[i] < count[min]) {
                    min = i;
                }
            }
            result[index] = min;
            count[min] = Integer.MAX_VALUE;
            index++;
            k--;
        }
        return result;
    }
}