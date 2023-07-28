class Solution {
    public List<Integer> powerfulIntegers(int x, int y, int bound) {
        
        Set<Integer> result = new HashSet<>();
        for (int i = 0; Math.pow(x, i) <= bound; i++) {
            for (int j = 0; Math.pow(y, j) <= bound; j++) {
                int sum = (int) (Math.pow(x, i) + Math.pow(y, j));
                if (sum <= bound) {
                    result.add(sum);
                }
            }
        }
        return new ArrayList<>(result);
    }
}