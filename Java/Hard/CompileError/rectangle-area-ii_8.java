class Solution {
    public int rectangleArea(int[][] rectangles) {
        
        int mod = 1000000007;
        int n = rectangles.length;
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int[] rect : rectangles) {
            map.put(rect[0], 0);
            map.put(rect[2], 0);
        }
        int t = 0;
        for (int x : map.keySet()) {
            map.put(x, t++);
        }
        SegmentTree tree = new SegmentTree(t);
        long ans = 0;
        Arrays.sort(rectangles, Comparator.comparingInt(a -> a[1]));
        for (int[] rect : rectangles) {
            tree.update(map.get(rect[0]), map.get(rect[2]), 1, 0, t - 1, rect[3] - rect[1]);
            ans = (ans + tree.sum) % mod;
        }
        return (int) ans;
    }

    class SegmentTree {
        int[] tag;
        long[] sum;
        int n;

        public SegmentTree(int n) {
            this.n = n;
            tag = new int[n << 2];
            sum = new long[n << 2];
        }

        private void pushUp(int rt) {
            sum[rt] = sum[rt << 1] + sum[rt << 1 | 1];
        }

        private void pushDown(int rt, int ln, int rn) {
            if (tag[rt] != 0) {
                tag[rt << 1] += tag[rt];
                tag[rt << 1 | 1] += tag[rt];
                sum[rt << 1] += (long) tag[rt] * ln;
                sum[rt << 1 | 1] += (long) tag[rt] * rn;
                tag[rt] = 0;
            }
        }

        public void update(int L, int R, int v, int l, int r, int len) {
            if (L <= l && r <= R) {
                tag[1] += v;
                sum[1] += (long) v * len;
                return;
            }
            int m = (l + r) >> 1;
            pushDown(1, m - l + 1, r - m);
            if (L <= m) {
                update(L, R, v, l, m, len
    }
}