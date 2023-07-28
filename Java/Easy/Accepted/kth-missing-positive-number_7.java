class Solution {
    public int findKthPositive(int[] arr, int k) {
        
        int i = 0;
        int j = 0;
        while (i < arr.length) {
            if (arr[i] != j + 1) {
                k--;
                if (k == 0) {
                    return j + 1;
                }
            } else {
                i++;
            }
            j++;
        }
        return j + k;
    }
}