class Solution {
    public List<Integer> filterRestaurants(int[][] restaurants, int veganFriendly, int maxPrice, int maxDistance) {
        
        List<Integer> result = new ArrayList<>();
        if (restaurants.length == 0) {
            return result;
        }
        for (int i = 0; i < restaurants.length; i++) {
            if (veganFriendly == 1 && restaurants[i][2] == 0) {
                continue;
            }
            if (restaurants[i][3] > maxPrice || restaurants[i][4] > maxDistance) {
                continue;
            }
            result.add(restaurants[i][0]);
        }
        Collections.sort(result, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                int o1Rating = 0;
                int o2Rating = 0;
                for (int i = 0; i < restaurants.length; i++) {
                    if (restaurants[i][0] == o1) {
                        o1Rating = restaurants[i][1];
                    }
                    if (restaurants[i][0] == o2) {
                        o2Rating = restaurants[i][1];
                    }
                }
                if (o1Rating == o2Rating) {
                    return o2 - o1;
                }
                return o2Rating - o1Rating;
            }
        });
        return result;
    }
}