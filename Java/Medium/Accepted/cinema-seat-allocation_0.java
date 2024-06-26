class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int i = 0; i < reservedSeats.length; i++) {
            if (!map.containsKey(reservedSeats[i][0])) {
                map.put(reservedSeats[i][0], new HashSet<>());
            }
            map.get(reservedSeats[i][0]).add(reservedSeats[i][1]);
        }
        int res = 0;
        for (Integer key : map.keySet()) {
            Set<Integer> set = map.get(key);
            if (!set.contains(2) && !set.contains(3) && !set.contains(4) && !set.contains(5)) {
                res++;
                if (!set.contains(6) && !set.contains(7) && !set.contains(8) && !set.contains(9)) {
                    res++;
                }
            } else if (!set.contains(6) && !set.contains(7) && !set.contains(8) && !set.contains(9)) {
                res++;
            } else if (!set.contains(4) && !set.contains(5) && !set.contains(6) && !set.contains(7)) {
                res++;
            }
        }
        return res + (n - map.size()) * 2;
    }
}