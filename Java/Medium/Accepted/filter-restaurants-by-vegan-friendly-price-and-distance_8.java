class Solution {
    public List<Integer> filterRestaurants(int[][] restaurants, int veganFriendly, int maxPrice, int maxDistance) {
        
        List<Integer> res = new ArrayList();
        for (int[] restaurant : restaurants) {
            if (veganFriendly == 1 && restaurant[2] == 0) {
                continue;
            }
            if (restaurant[3] > maxPrice || restaurant[4] > maxDistance) {
                continue;
            }
            res.add(restaurant[0]);
        }
        Collections.sort(res, new Comparator<Integer>() {
            @Override
            public int compare(Integer id1, Integer id2) {
                for (int[] restaurant : restaurants) {
                    if (restaurant[0] == id1) {
                        for (int[] restaurant2 : restaurants) {
                            if (restaurant2[0] == id2) {
                                if (restaurant[1] != restaurant2[1]) {
                                    return restaurant2[1] - restaurant[1];
                                }
                                return restaurant2[0] - restaurant[0];
                            }
                        }
                    }
                }
                return 0;
            }
        });
        return res;
    }
}