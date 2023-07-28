class Solution {
    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        
        return shopping(price, special, needs, 0);
    }
    
    private int shopping(List<Integer> price, List<List<Integer>> special, List<Integer> needs, int start) {
        int res = directPurchase(price, needs);
        for (int i = start; i < special.size(); i++) {
            List<Integer> offer = special.get(i);
            List<Integer> clone = new ArrayList<>(needs);
            int j = 0;
            for (; j < needs.size(); j++) {
                int diff = clone.get(j) - offer.get(j);
                if (diff < 0) {
                    break;
                }
                clone.set(j, diff);
            }
            if (j == needs.size()) {
                res = Math.min(res, offer.get(j) + shopping(price, special, clone, i));
            }
        }
        return res;
    }
    
    private int directPurchase(List<Integer> price, List<Integer> needs) {
        int res = 0;
        for (int i = 0; i < price.size(); i++) {
            res += price.get(i) * needs.get(i);
        }
        return res;
    }
}