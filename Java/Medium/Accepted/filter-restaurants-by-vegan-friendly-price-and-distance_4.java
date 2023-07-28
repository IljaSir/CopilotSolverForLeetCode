class Solution {
    public List<Integer> filterRestaurants(int[][] restaurants, int veganFriendly, int maxPrice, int maxDistance) {
        
        List<Integer> ids = new ArrayList<>();
        for (int i = 0; i < restaurants.length; i++) {
            if (restaurants[i][2] < veganFriendly) {
                continue;
            }
            if (restaurants[i][3] > maxPrice) {
                continue;
            }
            if (restaurants[i][4] > maxDistance) {
                continue;
            }
            ids.add(restaurants[i][0]);
        }
        Collections.sort(ids, (a, b) -> {
            for (int i = 0; i < restaurants.length; i++) {
                if (restaurants[i][0] == a) {
                    for (int j = 0; j < restaurants.length; j++) {
                        if (restaurants[j][0] == b) {
                            if (restaurants[i][1] != restaurants[j][1]) {
                                return restaurants[j][1] - restaurants[i][1];
                            } else {
                                return restaurants[j][0] - restaurants[i][0];
                            }
                        }
                    }
                }
            }
            return 0;
        });
        return ids;
    }
}