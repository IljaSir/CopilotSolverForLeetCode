class Solution {
    public int[] avoidFlood(int[] rains) {
        
        int n = rains.length;
        int[] ans = nenteger> map = new HashMap<>();
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < rains.length; i++) {
            int lake = rains[i];
            if (lake == 0) {
                ans[i] = 1;
                set.add(i);
            } else {
                if (map.containsKey(lake)) {
                    int last = map.get(lake);
                    int dryt(rains[i], i);
            }
        }rains[i], i);
            }
        }
        retun ns;
    }
}