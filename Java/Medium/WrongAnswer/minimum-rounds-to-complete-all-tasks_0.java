class Solution {
    public int minimumRounds(int[] tasks) {
        
        Map<Integer, Integer> map = new HashMap<>();
        for (int task : tasks) {
            map.put(task, map.getOrDefault(task, 0) + 1);
        }
        int ans = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int count = entry.getValue();
            if (count % 2 == 1) {
                ans += count / 2 + 1;
            } else {
                ans += count / 2;
            }
        }
        return ans;
    }
}