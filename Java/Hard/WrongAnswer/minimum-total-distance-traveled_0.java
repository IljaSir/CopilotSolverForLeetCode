class Solution {
    public long minimumTotalDistance(List<Integer> robot, int[][] factory) {
        
        long res = 0;
        int[] limit = new int[factory.length];
        for (int i = 0; i < factory.length; i++) {
            limit[i] = factory[i][1];
        }
        Collections.sort(robot);
        Arrays.sort(factory, (a, b) -> a[0] - b[0]);
        for (int i = 0, j = robot.size() - 1; i < j; i++, j--) {
            int x = robot.get(i), y = robot.get(j);
            int idx = find(factory, x);
            if (limit[idx] > 0) {
                res += y - x;
                limit[idx]--;
            } else {
                idx = find(factory, y);
                res += y - x;
                limit[idx]--;
            }
        }
        return res;
    }

    private int find(int[][] factory, int x) {
        int l = 0, r = factory.length - 1;
        while (l < r) {
            int m = l + r >> 1;
            if (factory[m][0] < x) {
                l = m + 1;
            } else {
                r = m;
            }
        }
        return l;
    }
}