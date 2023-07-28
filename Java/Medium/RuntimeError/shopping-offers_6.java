class Solution {
    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        
        int[] p = new int[price.size()];
        int[] n = new int[needs.size()];
        for (int i = 0; i < price.size(); i++) {
            p[i] = price.get(i);
        }
        for (int i = 0; i < needs.size(); i++) {
            n[i] = needs.get(i);
        }
        int[][] s = new int[special.size()][];
        for (int i = 0; i < special.size(); i++) {
            s[i] = new int[special.get(i).size()];
            for (int j = 0; j < special.get(i).size(); j++) {
                s[i][j] = special.get(i).get(j);
            }
        }
        return shoppingOffers(p, s, n);
    }
    public int shoppingOffers(int[] price, int[][] special, int[] needs) {
        return shopping(price, special, needs, 0);
    }
    private int shopping(int[] price, int[][] special, int[] needs, int pos) {
        int n = price.length;
        int min = directPurchase(price, needs);
        for (int i = pos; i < special.length; i++) {
            int[] clone = needs.clone();
            for (int j = 0; j < n; j++) {
                int diff = clone[j] - special[i][j];
                if (diff < 0) {
                    break;
                }
                clone[j] = diff;
            }
            min = Math.min(min, shopping(price, special, clone, i) + special[i][n]);
        }
        return min;
    }
    private int directPurchase(int[] price, int[] needs) {
        int sum = 0;
        for (int i = 0; i < price.length; i++) {
            sum += price[i] * needs[i];
        }
        return sum;
    }
}