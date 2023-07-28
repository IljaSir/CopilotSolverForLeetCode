class Solution {
    public List<Integer> numOfBurgers(int tomatoSlices, int cheeseSlices) {
        
        List<Integer> res = new ArrayList<>();
        if (tomatoSlices % 2 == 0) {
            int jumbo = tomatoSlices / 2 - cheeseSlices;
            int small = cheeseSlices - jumbo;
            if (jumbo >= 0 && small >= 0) {
                res.add(jumbo);
                res.add(small);
            }
        }
        return res;
    }
}