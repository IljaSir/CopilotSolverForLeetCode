class Solution {
    public List<Integer> numOfBurgers(int tomatoSlices, int cheeseSlices) {
        
        List<Integer> res = new ArrayList<>();
        int jumbo = 0;
        int small = 0;
        if (tomatoSlices % 2 == 0 && tomatoSlices / 2 >= cheeseSlices && tomatoSlices / 2 - cheeseSlices <= cheeseSlices) {
            small = tomatoSlices / 2 - cheeseSlices;
            jumbo = cheeseSlices - small;
            res.add(jumbo);
            res.add(small);
        }
        return res;
    }
}