class Solution {
    public int numRabbits(int[] answers) {
        
        Map<Integer, Integer> map = new HashMap<>();
        for (int answer : answers) {
            map.put(answer, map.getOrDefault(answer, 0) + 1);
        }
        int res = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int x = entry.getKey(), y = entry.getValue();
            res += (x + y) / (x + 1) * (x + 1);
        }
        return res;
    }
}