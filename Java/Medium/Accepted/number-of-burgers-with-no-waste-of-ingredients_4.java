class Solution {
    public List<Integer> numOfBurgers(int tomatoSlices, int cheeseSlices) {
        
        List<Integer> res = new ArrayList<>();
        int n = tomatoSlices - 2 * cheeseSlices;
        if (n < 0 || n % 2 != 0) {
            return res;
        }
        int m = cheeseSlices - n / 2;
        if (m < 0) {
            return res;
        }
        res.add(n / 2);
        res.add(m);
        return res;
    }
}