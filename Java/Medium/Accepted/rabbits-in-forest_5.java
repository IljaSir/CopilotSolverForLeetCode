class Solution {
    public int numRabbits(int[] answers) {
        
        int ans = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int x : answers) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int key = entry.getKey();
            int value = entry.getValue();
            ans += (value + key) / (key + 1) * (key + 1);
        }
        return ans;
    }
}