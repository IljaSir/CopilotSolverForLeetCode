class Solution {
    public boolean canCross(int[] stones) {
        
        int n = stones.length;
        if (n == 0) {
            return true;
        }
        
        if (stones[1] != 1) {
            return false;
        }
        
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(stones[i], new HashSet<>());
        }
        map.get(1).add(1);
        
        for (int i = 1; i < n; i++) {
            if (map.get(stones[i]).isEmpty()) {
                continue;
            }
            
            for (int k : map.get(stones[i])) {
                for (int step = k - 1; step <= k + 1; step++) {
                    if (step > 0 && map.containsKey(stones[i] + step)) {
                        map.get(stones[i] + step).add(step);
                    }
                }
            }
        }
        
        return !map.get(stones[n - 1]).isEmpty();
    }
}