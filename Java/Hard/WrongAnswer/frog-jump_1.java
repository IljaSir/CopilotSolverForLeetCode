class Solution {
    public boolean canCross(int[] stones) {
        
        if (stones[1] != 1) {
            return false;
        }
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int i = 0; i < stones.length; i++) {
            map.put(stones[i], new HashSet<>());
        }
        map.get(1).add(1);
        for (int i = 0; i < stones.length; i++) {
            int stone = stones[i];
            for (int step : map.get(stone)) {
                int reach = stone + step;
                if (reach == stones[stones.length - 1]) {
                    return true;
                }
                Set<Integer> set = map.get(reach);
                if (set != null) {
                    set.add(step);
                    if (step - 1 > 0) {
                        set.add(step - 1);
                    }
                    set.add(step + 1);
                }
            }
        }
        return false;
    }
}