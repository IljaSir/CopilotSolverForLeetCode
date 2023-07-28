class Solution {
    public int minimumRounds(int[] tasks) {
        
        int n = tasks.length;
        int[] arr = new int[1000001];
        for (int i = 0; i < n; i++) {
            arr[tasks[i]]++;
        }
        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) continue;
            arr[i] -= 2;
            if (arr[i] > 0) {
                if (arr[i] % 3 == 0) {
                    res += arr[i] / 3;
                } else {
                    res += arr[i] / 3 + 1;
                }
            }
        }
        return res;
    }
}