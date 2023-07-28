class Solution {
    public int findSpecialInteger(int[] arr) {
        
        int n = arr.length;
        int count = 0;
        int max = 0;
        int ans = arr[0];
        for (int i = 0; i < n; i++) {
            if (arr[i] == arr[i+1]) {
                count++;
            } else {
                count = 0;
            }
            if (count > max) {
                max = count;
                ans = arr[i];
            }
        }
        return ans;
    }
}