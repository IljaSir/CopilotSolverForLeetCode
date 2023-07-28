class Solution {
    public List<Integer> powerfulIntegers(int x, int y, int bound) {
        
        Set<Integer> set = new HashSet<>();
        int i = 0;
        while (Math.pow(x, i) + 1 <= bound) {
            int j = 0;
            while (Math.pow(x, i) + Math.pow(y, j) <= bound) {
                set.add((int) (Math.pow(x, i) + Math.pow(y, j)));
                if (y == 1) {
                    break;
                }
                j++;
            }
            if (x == 1) {
                break;
            }
            i++;
        }
        return new ArrayList<>(set);
    }
}