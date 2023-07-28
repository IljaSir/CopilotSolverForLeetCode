class Solution {
    public List<Integer> filterRestaurants(int[][] restaurants, int veganFriendly, int maxPrice, int maxDistance) {
        
        List<int[]> list = new ArrayList<>();
        for (int[] r : restaurants) {
            if (veganFriendly == 1 && r[2] == 0) {
                continue;
            }
            if (r[3] <= maxPrice && r[4] <= maxDistance) {
                list.add(r);
            }
        }
        Collections.sort(list, (a, b) -> {
            if (a[1] == b[1]) {
                return b[0] - a[0];
            }
            return b[1] - a[1];
        });
        List<Integer> res = new ArrayList<>();
        for (int[] r : list) {
            res.add(r[0]);
        }
        return res;
    }
}