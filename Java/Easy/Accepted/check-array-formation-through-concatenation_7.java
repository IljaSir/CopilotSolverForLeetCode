class Solution {
    public boolean canFormArray(int[] arr, int[][] pieces) {
        
        for (int[] piece : pieces) {
            int i = 0;
            for (; i < arr.length; i++) {
                if (arr[i] == piece[0]) {
                    break;
                }
            }
            if (i == arr.length) {
                return false;
            }
            for (int j = 1; j < piece.length; j++) {
                if (i + j >= arr.length) {
                    return false;
                }
                if (arr[i + j] != piece[j]) {
                    return false;
                }
            }
        }
        return true;
    }
}