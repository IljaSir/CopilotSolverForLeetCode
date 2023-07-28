class Solution {
    public List<Integer> numOfBurgers(int tomatoSlices, int cheeseSlices) {
        
        List<Integer> ret = new ArrayList<>();
        int jumbo = 0;
        int small = 0;
        for (int i = 0; i < cheeseSlices; i++) {
            jumbo = i;
            small = cheeseSlices - i;
            if (jumbo * 4 + small * 2 == tomatoSlices) {
                ret.add(jumbo);
                ret.add(small);
                return ret;
            }
        }
        return ret;
    }
}