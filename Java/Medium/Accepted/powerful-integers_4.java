class Solution {
    public List<Integer> powerfulIntegers(int x, int y, int bound) {
        
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 20; j++) {
                int val = (int) (Math.pow(x, i) + Math.pow(y, j));
                if (val <= bound) {
                    set.add(val);
                }
            }
        }
        return new ArrayList<>(set);
    }
}