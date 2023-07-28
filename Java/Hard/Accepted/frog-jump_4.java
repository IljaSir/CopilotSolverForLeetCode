class Solution {
    public boolean canCross(int[] stones) {
        
        int n = stones.length;
        if (n == 0) {
            return true;
        }
        if (n == 1) {
            return stones[0] == 0;
        }
        if (stones[1] != 1) {
            return false;
        }
        if (n == 2) {
            return true;
        }
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(stones[i], new HashSet<>());
        }
        map.get(1).add(1);
        for (int i = 1; i < n; i++) {
            int pos = stones[i];
            for (int k : map.get(pos)) {
                for (int step = k - 1; step <= k + 1; step++) {
                    if (step > 0 && map.containsKey(pos + step)) {
                        map.get(pos + step).add(step);
                    }
                }
            }
        }
        return map.get(stones[n - 1]).size() > 0;
    }
}