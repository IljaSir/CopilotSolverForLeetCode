class Solution {
    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        
        return shopping(price, special, needs, 0);
    }
    public int shopping(List<Integer> price, List<List<Integer>> special, List<Integer> needs, int start) {
        int min = 0;
        for (int i = 0; i < needs.size(); i++) {
            min += price.get(i) * needs.get(i);
        }
        for (int i = start; i < special.size(); i++) {
            List<Integer> offer = special.get(i);
            List<Integer> clone = new ArrayList<Integer>(needs);
            int j = 0;
            for (; j < needs.size(); j++) {
                int diff = clone.get(j) - offer.get(j);
                if (diff < 0) {
                    break;
                }
                clone.set(j, diff);
            }
            if (j == needs.size()) {
                min = Math.min(min, shopping(price, special, clone, i) + offer.get(j));
            }
        }
        return min;
    }
}