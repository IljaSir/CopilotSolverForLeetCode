class Solution {
    public int longestSubsequence(int[] arr, int difference) {
        
        HashMap<Integer, Integer> map = new HashMap<>();
        int max = 1;
        for (int i = 0; i < arr.length; i++) {
            int key = arr[i] - difference;
            if (map.containsKey(key)) {
                map.put(arr[i], map.get(key) + 1);
            } else {
                map.put(arr[i], 1);
            }
            max = Math.max(max, map.get(arr[i]));
        }
        return max;
    }
}