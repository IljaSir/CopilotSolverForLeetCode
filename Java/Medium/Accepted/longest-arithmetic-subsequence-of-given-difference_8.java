class Solution {
    public int longestSubsequence(int[] arr, int difference) {
        
        HashMap<Integer, Integer> map = new HashMap<>();
        int result = 1;
        for (int i = 0; i < arr.length; i++) {
            int prev = arr[i] - difference;
            if (map.containsKey(prev)) {
                map.put(arr[i], map.get(prev) + 1);
            } else {
                map.put(arr[i], 1);
            }
            result = Math.max(result, map.get(arr[i]));
        }
        return result;
    }
}