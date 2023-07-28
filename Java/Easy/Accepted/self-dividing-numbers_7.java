class Solution {
    public List<Integer> selfDividingNumbers(int left, int right) {
        
        List<Integer> list = new ArrayList();
        for (int i = left; i <= right; i++) {
            if (isSelfDividing(i)) {
                list.add(i);
            }
        }
        return list;
    }
    public boolean isSelfDividing(int n) {
        int t = n;
        while (t != 0) {
            int d = t % 10;
            if (d == 0 || n % d != 0) {
                return false;
            }
            t /= 10;
        }
        return true;
    }
}