class Solution {
    public List<Integer> numOfBurgers(int tomatoSlices, int cheeseSlices) {
        
        List<Integer> result = new ArrayList<>();
        int jumbo = 0;
        int small = 0;
        int cheese = 0;
        int tomato = 0;
        for (int i = 0; i <= cheeseSlices; i++) {
            cheese = i;
            tomato = cheeseSlices - cheese;
            if (tomato * 2 + cheese * 4 == tomatoSlices) {
                result.add(tomato);
                result.add(cheese);
                return result;
            }
        }
        return result;
    }
}