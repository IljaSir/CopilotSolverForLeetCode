class Solution {
    public List<Integer> powerfulIntegers(int x, int y, int bound) {
        
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < bound; i++) {
            for (int j = 0; j < bound; j++) {
                int val = (int) Math.pow(x, i) + (int) Math.pow(y, j);
                if (val > bound) {
                    break;
                }
                set.add(val);
            }
            if (x == 1) {
                break;
            }
        }
        return new ArrayList<>(set);
    }
}