class Solution {
    public List<Integer> numOfBurgers(int tomatoSlices, int cheeseSlices) {
        
        List<Integer> ans = new ArrayList<>();
        int x = tomatoSlices - 2 * cheeseSlices;
        int y = 4 * cheeseSlices - tomatoSlices;
        if (x % 2 == 0 && y % 2 == 0 && x >= 0 && y >= 0) {
            ans.add(x / 2);
            ans.add(y / 2);
        }
        return ans;
    }
}