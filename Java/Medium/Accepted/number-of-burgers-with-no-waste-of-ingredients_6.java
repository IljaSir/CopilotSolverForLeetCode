class Solution {
    public List<Integer> numOfBurgers(int tomatoSlices, int cheeseSlices) {
        
        List<Integer> result = new ArrayList<>();
        int jumbo = 0, small = 0;
        if (tomatoSlices % 2 == 1) {
            return result;
        }
        jumbo = (tomatoSlices / 2) - cheeseSlices;
        small = cheeseSlices - jumbo;
        if (jumbo < 0 || small < 0) {
            return result;
        }
        result.add(jumbo);
        result.add(small);
        return result;
    }
}