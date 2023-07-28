class Solution {
    public int minOperations(int[] target, int[] arr) {
        
        int n = target.length;
        int m = arr.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(target[i], i);
        }
        int[] dp = new int[n];
        int len = 0;
        for (int i = 0; i < m; i++) {
            if (map.containsKey(arr[i])) {
                int index = map.get(arr[i]);
                int pos = Arrays.binarySearch(dp, 0, len, index);
                if (pos < 0) {
                    pos = -(pos + 1);
                }
                dp[pos] = index;
                if (pos == len) {
                    len++;
                }
            }
        }
        return n - len;
    }
}