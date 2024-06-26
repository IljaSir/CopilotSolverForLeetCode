class Solution {
    public int numFactoredBinaryTrees(int[] arr) {
        
        Arrays.sort(arr);
        Map<Integer, Long> dp = new HashMap<>();
        for(int i = 0; i < arr.length; i++) {
            dp.put(arr[i], 1L);
            for(int j = 0; j < i; j++) {
                if(arr[i] % arr[j] == 0 && dp.containsKey(arr[i] / arr[j])) {
                    dp.put(arr[i], (dp.get(arr[i]) + dp.get(arr[j]) * dp.get(arr[i] / arr[j])) % 1000000007);
                }
            }
        }
        long ans = 0;
        for(long val : dp.values()) {
            ans = (ans + val) % 1000000007;
        }
        return (int) ans;
    }
}