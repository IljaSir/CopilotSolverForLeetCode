class Solution {
    public String longestDiverseString(int a, int b, int c) {
        
        StringBuilder sb = new StringBuilder();
        PriorityQueue<int[]> pq = new PriorityQueue<>((x, y) -> y[0] - x[0]);
        if (a > 0) pq.add(new int[]{a, 0});
        if (b > 0) pq.add(new int[]{b, 1});
        if (c > 0) pq.add(new int[]{c, 2});
        while (pq.size() > 0) {
            int[] x = pq.poll();
            if (sb.length() >= 2 && sb.charAt(sb.length() - 1) == (char)('a' + x[1]) && sb.charAt(sb.length() - 2) == (char)('a' + x[1])) {
                if (pq.size() == 0) break;
                int[] y = pq.poll();
                sb.append((char)('a' + y[1]));
                if (--y[0] > 0) pq.add(y);
                pq.add(x);
            } else {
                sb.append((char)('a' + x[1]));
                if (--x[0] > 0) pq.add(x);
            }
        }
        return sb.toString();
    }
}