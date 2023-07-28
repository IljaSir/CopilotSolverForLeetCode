class Solution {
    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        
        return shopping(price, special, needs, 0);
    }
    
    public int shopping(List<Integer> price, List<List<Integer>> special, List<Integer> needs, int i) {
        int min = directPurchase(price, needs);
        for(; i < special.size(); i++) {
            List<Integer> offer = special.get(i);
            List<Integer> temp = new ArrayList<>();
            for(int j = 0; j < needs.size(); j++) {
                if(needs.get(j) < offer.get(j)) {
                    temp = null;
                    break;
                }
                temp.add(needs.get(j) - offer.get(j));
            }
            if(temp != null) {
                min = Math.min(min, offer.get(offer.size() - 1) + shopping(price, special, temp, i));
            }
        }
        return min;
    }
    
    public int directPurchase(List<Integer> price, List<Integer> needs) {
        int total = 0;
        for(int i = 0; i < price.size(); i++) {
            total += price.get(i) * needs.get(i);
        }
        return total;
    }
}