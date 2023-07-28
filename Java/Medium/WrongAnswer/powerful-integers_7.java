class Solution {
    public List<Integer> powerfulIntegers(int x, int y, int bound) {
        
        List<Integer> result = new ArrayList<>();
        int i = 0;
        int j = 0;
        int sum = 0;
        while (sum <= bound) {
            sum = (int) (Math.pow(x, i) + Math.pow(y, j));
            if (sum <= bound && !result.contains(sum)) {
                result.add(sum);
            }
            if (x == 1) {
                break;
            }
            if (x == 1 && y == 1) {
                break;
            }
            if (y == 1) {
                i++;
                j = 0;
                continue;
            }
            if (j < bound) {
                j++;
            } else {
                i++;
                j = 0;
            }
        }
        return result;
    }
}