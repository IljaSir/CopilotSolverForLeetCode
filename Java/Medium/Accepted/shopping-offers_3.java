class Solution {
    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        
        return shopping(price, special, needs, 0);
    }
    
    private int shopping(List<Integer> price, List<List<Integer>> special, List<Integer> needs, int pos) {
        int min = directPurchase(price, needs);
        for (int i = pos; i < special.size(); i++) {
            List<Integer> offer = special.get(i);
            List<Integer> tmp = new ArrayList<>();
            for (int j = 0; j < needs.size(); j++) {
                if (needs.get(j) < offer.get(j)) {
                    tmp = null;
                    break;
                }
                tmp.add(needs.get(j) - offer.get(j));
            }
            if (tmp != null) {
                min = Math.min(min, offer.get(offer.size() - 1) + shopping(price, special, tmp, i));
            }
        }
        return min;
    }
    
    private int directPurchase(List<Integer> price, List<Integer> needs) {
        int total = 0;
        for (int i = 0; i < price.size(); i++) {
            total += price.get(i) * needs.get(i);
        }
        return total;
    }
}