class Solution {
    public long makeSubKSumEqual(int[] arr, int k) {
        
        int n = arr.length;
        int[] subSum = new int[n];
        subSum[0] = arr[0];
        for (int i = 1; i < n; i++) {
            subSum[i] = subSum[i - 1] + arr[i];
        }
        int[] mod = new int[n];
        for (int i = 0; i < n; i++) {
            mod[i] = subSum[i] % k;
        }
        long ans = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int modVal = mod[i];
            if (map.containsKey(modVal)) {
                ans = Math.max(ans, i - map.get(modVal));
            } else {
                map.put(modVal, i);
            }
        }
        return n - ans;
    }
}