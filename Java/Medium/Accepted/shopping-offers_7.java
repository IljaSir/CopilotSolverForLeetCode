class Solution {
    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        
        return shopping(price, special, needs, 0);
    }
    
    public int shopping(List<Integer> price, List<List<Integer>> special, List<Integer> needs, int start) {
        int j = 0, localMin = dot(needs, price);
        for (int i = start; i < special.size(); i++) {
            List<Integer> offer = special.get(i);
            ArrayList<Integer> clone = new ArrayList<Integer>(needs);
            for (j = 0; j < needs.size(); j++) {
                int diff = needs.get(j) - offer.get(j);
                if (diff < 0) break;
                clone.set(j, diff);
            }
            if (j == needs.size())
                localMin = Math.min(localMin, offer.get(j) + shopping(price, special, clone, i));
        }
        return localMin;
    }
    
    public int dot(List<Integer> a, List<Integer> b) {
        int sum = 0;
        for (int i = 0; i < a.size(); i++) {
            sum += a.get(i) * b.get(i);
        }
        return sum;
    }
}