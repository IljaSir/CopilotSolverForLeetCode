class Solution {
    public List<Integer> numOfBurgers(int tomatoSlices, int cheeseSlices) {
        
        List<Integer> result = new ArrayList<>();
        if (tomatoSlices % 2 != 0 || cheeseSlices > tomatoSlices / 2 || cheeseSlices * 4 < tomatoSlices) {
            return result;
        }
        int jumbo = (tomatoSlices / 2 - cheeseSlices);
        int small = cheeseSlices - jumbo;
        result.add(jumbo);
        result.add(small);
        return result;
    }
}