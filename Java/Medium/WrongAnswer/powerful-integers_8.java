class Solution {
    public List<Integer> powerfulIntegers(int x, int y, int bound) {
        
        List<Integer> list = new ArrayList();
        int i = 0;
        int j = 0;
        int result = 0;
        while (true) {
            result = (int)Math.pow(x, i) + (int)Math.pow(y, j);
            if (result > bound) {
                break;
            }
            if (!list.contains(result)) {
                list.add(result);
            }
            if (y == 1) {
                break;
            }
            j++;
            if (Math.pow(y, j) > bound) {
                i++;
                j = 0;
            }
            if (Math.pow(x, i) > bound) {
                break;
            }
        }
        return list;
    }
}