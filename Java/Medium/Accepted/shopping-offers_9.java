class Solution {
    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        
        return shopping(price, special, needs, 0);
    }
    private int shopping(List<Integer> price, List<List<Integer>> special, List<Integer> needs, int pos) {
        int noOffer = directPurchase(price, needs);
        int min = noOffer;
        for (int i = pos; i < special.size(); i++) {
            List<Integer> offer = special.get(i);
            List<Integer> clone = new ArrayList<>(needs);
            for (int j = 0; j < needs.size(); j++) {
                int diff = clone.get(j) - offer.get(j);
                if (diff < 0) {
                    clone = null;
                    break;
                }
                clone.set(j, diff);
            }
            if (clone != null) {
                min = Math.min(min, offer.get(needs.size()) + shopping(price, special, clone, i));
            }
        }
        return min;
    }
    private int directPurchase(List<Integer> price, List<Integer> needs) {
        int sum = 0;
        for (int i = 0; i < price.size(); i++) {
            sum += price.get(i) * needs.get(i);
        }
        return sum;
    }
}