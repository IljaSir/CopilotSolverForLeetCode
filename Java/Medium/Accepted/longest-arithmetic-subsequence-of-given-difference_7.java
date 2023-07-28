class Solution {
    public int longestSubsequence(int[] arr, int difference) {
        
        Map<Integer, Integer> map = new HashMap<>();
        int n = arr.length;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int val = arr[i];
            int prev = val - difference;
            if (map.containsKey(prev)) {
                map.put(val, map.get(prev) + 1);
            } else {
                map.put(val, 1);
            }
            ans = Math.max(ans, map.get(val));
        }
        return ans;
    }
}