class Solution {
    public int minimumRounds(int[] tasks) {
        
        int n = tasks.length;
        int[] arr = new int[100000000];
        for(int i = 0; i < n; i++) {
            arr[tasks[i]]++;
        }
        int ans = 0;
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] > 0) {
                if(arr[i] % 2 == 0) {
                    ans += arr[i] / 2;
                } else {
                    ans += arr[i] / 2 + 1;
                }
            }
        }
        return ans;
    }
}