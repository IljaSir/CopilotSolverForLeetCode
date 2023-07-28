class Solution {
    public List<Integer> numOfBurgers(int tomatoSlices, int cheeseSlices) {
        
        List<Integer> result = new ArrayList<>();
        int jumbo = 0;
        int small = 0;
        if (tomatoSlices % 2 != 0) {
            return result;
        }
        int total = tomatoSlices / 2;
        if (total < cheeseSlices) {
            return result;
        }
        jumbo = cheeseSlices;
        small = total - cheeseSlices;
        if (jumbo < 0 || small < 0) {
            return result;
        }
        if (jumbo * 4 + small * 2 != tomatoSlices) {
            return result;
        }
        result.add(jumbo);
        result.add(small);
        return result;
    }
}