class Solution {
    public List<Integer> filterRestaurants(int[][] restaurants, int veganFriendly, int maxPrice, int maxDistance) {
        
        List<Integer> result = new ArrayList<>();
        for (int[] restaurant : restaurants) {
            if (restaurant[2] < veganFriendly) continue;
            if (restaurant[3] > maxPrice) continue;
            if (restaurant[4] > maxDistance) continue;
            result.add(restaurant[0]);
        }
        result.sort((a, b) -> {
            for (int[] restaurant : restaurants) {
                if (restaurant[0] == a) {
                    for (int[] restaurant2 : restaurants) {
                        if (restaurant2[0] == b) {
                            if (restaurant[1] > restaurant2[1]) return -1;
                            if (restaurant[1] < restaurant2[1]) return 1;
                            if (restaurant[0] > restaurant2[0]) return -1;
                            if (restaurant[0] < restaurant2[0]) return 1;
                        }
                    }
                }
            }
            return 0;
        });
        return result;
    }
}