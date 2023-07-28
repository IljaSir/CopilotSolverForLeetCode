class Solution {
    public List<Integer> filterRestaurants(int[][] restaurants, int veganFriendly, int maxPrice, int maxDistance) {
        
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < restaurants.length; i++) {
            int[] restaurant = restaurants[i];
            if (restaurant[2] >= veganFriendly && restaurant[3] <= maxPrice && restaurant[4] <= maxDistance) {
                result.add(restaurant[0]);
            }
        }
        result.sort((a, b) -> {
            int ratingA = 0;
            int ratingB = 0;
            for (int i = 0; i < restaurants.length; i++) {
                int[] restaurant = restaurants[i];
                if (restaurant[0] == a) {
                    ratingA = restaurant[1];
                }
                if (restaurant[0] == b) {
                    ratingB = restaurant[1];
                }
            }
            if (ratingA == ratingB) {
                return b - a;
            } else {
                return ratingB - ratingA;
            }
        });
        return result;
    }
}