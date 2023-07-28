class Solution {
    public boolean containsPattern(int[] arr, int m, int k) {
        
        int i = 0;
        int j = 0;
        int count = 0;
        while (i < arr.length) {
            if (arr[i] == arr[j]) {
                i++;
                if (i - j == m) {
                    count++;
                    j = i;
                }
            } else {
                count = 0;
                j++;
                i = j;
            }
            if (count == k) {
                return true;
            }
        }
        return false;
    }
}