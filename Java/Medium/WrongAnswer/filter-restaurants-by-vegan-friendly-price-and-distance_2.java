class Solution {
    public List<Integer> filterRestaurants(int[][] restaurants, int veganFriendly, int maxPrice, int maxDistance) {
        
        List<Integer> result = new ArrayList<>();
        for (int[] restaurant : restaurants) {
            if (veganFriendly == 1 && restaurant[2] == 0) {
                continue;
            }
            if (restaurant[3] > maxPrice || restaurant[4] > maxDistance) {
                continue;
            }
            result.add(restaurant[0]);
        }
        Collections.sort(result, (a, b) -> {
            for (int[] restaurant : restaurants) {
                if (restaurant[0] == a) {
                    a = restaurant[1];
                }
                if (restaurant[0] == b) {
                    b = restaurant[1];
                }
            }
            return b - a;
        });
        return result;
    }
}