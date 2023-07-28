class Solution {
    public int[] avoidFlood(int[] rains) {
        
        int[] ans = new int[rains.length];
        Map<Integer, Integer> map = new HashMap<>();
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < rains.length; i++) {
            int lake = rains[i];
            if (lake == 0) {
                ans[i] = 1;
                set.add(i);
            } else {
                if (map.containsKey(lake)) {
                    int last = map.get(lake);
                    int dry = -1;
                    for (int j : set) {
                        if (j > last) {
                            dry = j;
                            break;
                        }
                    }
                    if (dry == -1) {
                        return new int[0];
                    } else {
                        ans[dry] = lake;
                        set.remove(dry);
                    }
                }
                map.put(lake, i);
                ans[i] = -1;
            }
        }
        return ans;
    }
}