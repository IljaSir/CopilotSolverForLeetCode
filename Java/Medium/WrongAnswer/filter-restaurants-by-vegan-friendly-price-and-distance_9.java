class Solution {
    public List<Integer> filterRestaurants(int[][] restaurants, int veganFriendly, int maxPrice, int maxDistance) {
        
        List<Integer> result = new ArrayList();
        List<Integer> temp = new ArrayList();
        for (int i = 0; i < restaurants.length; i++) {
            if (restaurants[i][2] >= veganFriendly && restaurants[i][3] <= maxPrice && restaurants[i][4] <= maxDistance) {
                temp.add(i);
            }
        }
        int[] rating = new int[temp.size()];
        for (int i = 0; i < temp.size(); i++) {
            rating[i] = restaurants[temp.get(i)][1];
        }
        Arrays.sort(rating);
        for (int i = rating.length - 1; i >= 0; i--) {
            for (int j = 0; j < temp.size(); j++) {
                if (restaurants[temp.get(j)][1] == rating[i]) {
                    result.add(restaurants[temp.get(j)][0]);
                }
            }
        }
        return result;
    }
}