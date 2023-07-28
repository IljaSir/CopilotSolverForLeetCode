class Solution {
    public int findSpecialInteger(int[] arr) {
        
        int n = arr.length;
        int count = 0;
        int index = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] == arr[index]) {
                count++;
            } else {
                count = 1;
                index = i;
            }
            if (count > n / 4) {
                return arr[index];
            }
        }
        return -1;
    }
}