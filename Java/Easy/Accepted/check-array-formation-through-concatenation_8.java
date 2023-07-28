class Solution {
    public boolean canFormArray(int[] arr, int[][] pieces) {
        
        int[] arr2 = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            arr2[i] = -1;
        }
        for (int i = 0; i < pieces.length; i++) {
            int[] piece = pieces[i];
            for (int j = 0; j < arr.length; j++) {
                if (arr[j] == piece[0]) {
                    for (int k = 0; k < piece.length; k++) {
                        if (j + k >= arr.length || arr[j + k] != piece[k]) {
                            return false;
                        }
                    }
                    for (int k = 0; k < piece.length; k++) {
                        arr2[j + k] = 1;
                    }
                }
            }
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr2[i] == -1) {
                return false;
            }
        }
        return true;
    }
}