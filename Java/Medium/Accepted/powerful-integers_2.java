class Solution {
    public List<Integer> powerfulIntegers(int x, int y, int bound) {
        
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < 20 && Math.pow(x, i) <= bound; i++) {
            for (int j = 0; j < 20 && Math.pow(y, j) <= bound; j++) {
                int sum = (int) (Math.pow(x, i) + Math.pow(y, j));
                if (sum <= bound) {
                    set.add(sum);
                }
            }
        }
        return new ArrayList<>(set);
    }
}