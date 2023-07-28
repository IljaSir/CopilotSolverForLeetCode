class Solution {
    public int[] numsSameConsecDiff(int n, int k) {
        
        int[] ans = new int[0];
        for (int i = 1; i < 10; i++) {
            ans = append(ans, dfs(n - 1, k, i));
        }
        return ans;
    }

    public int[] dfs(int n, int k, int num) {
        if (n == 0) {
            return new int[]{num};
        }
        int[] ans = new int[0];
        int tail = num % 10;
        if (tail - k >= 0) {
            ans = append(ans, dfs(n - 1, k, num * 10 + tail - k));
        }
        if (tail + k < 10 && k > 0) {
            ans = append(ans, dfs(n - 1, k, num * 10 + tail + k));
        }
        return ans;
    }

    public int[] append(int[] arr, int[] arr2) {
        int[] ans = new int[arr.length + arr2.length];
        System.arraycopy(arr, 0, ans, 0, arr.length);
        System.arraycopy(arr2, 0, ans, arr.length, arr2.length);
        return ans;
    }
}