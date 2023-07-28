class Solution {
    public List<Integer> numOfBurgers(int tomatoSlices, int cheeseSlices) {
        
        List<Integer> res = new ArrayList<>();
        int jumbo = (tomatoSlices - 2 * cheeseSlices) / 2;
        int small = cheeseSlices - jumbo;
        if (jumbo < 0 || small < 0 || (tomatoSlices - 2 * cheeseSlices) % 2 != 0) {
            return res;
        }
        res.add(jumbo);
        res.add(small);
        return res;
    }
}