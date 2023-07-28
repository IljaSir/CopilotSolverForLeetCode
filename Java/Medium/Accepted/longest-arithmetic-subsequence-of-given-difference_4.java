class Solution {
    public int longestSubsequence(int[] arr, int difference) {
        
        Map<Integer, Integer> map = new HashMap<>();
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            int num = arr[i];
            int prev = num - difference;
            int prevCount = map.getOrDefault(prev, 0);
            int curCount = prevCount + 1;
            map.put(num, curCount);
            max = Math.max(max, curCount);
        }
        return max;
    }
}