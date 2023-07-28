class Solution {
    public List<Integer> filterRestaurants(int[][] restaurants, int veganFriendly, int maxPrice, int maxDistance) {
        
        List<int[]> filtered = new ArrayList<>();
        for (int[] r : restaurants) {
            if (veganFriendly == 1 && r[2] == 0) {
                continue;
            }
            if (r[3] > maxPrice || r[4] > maxDistance) {
                continue;
            }
            filtered.add(r);
        }
        Collections.sort(filtered, new Comparator<int[]>() {
            @Override
            public int compare(int[] r1, int[] r2) {
                if (r1[1] > r2[1]) {
                    return -1;
                } else if (r1[1] < r2[1]) {
                    return 1;
                } else {
                    return r2[0] - r1[0];
                }
            }
        });
        List<Integer> result = new ArrayList<>();
        for (int[] r : filtered) {
            result.add(r[0]);
        }
        return result;
    }
}