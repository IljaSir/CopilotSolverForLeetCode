class Solution {
    public String longestDiverseString(int a, int b, int c) {
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((x, y) -> y[1] - x[1]);
        if (a > 0) pq.add(new int[]{'a', a});
        if (b > 0) pq.add(new int[]{'b', b});
        if (c > 0) pq.add(new int[]{'c', c});

        PriorityQueue<int[]> pq = new PriorityQueue<>((x, y) -> y[1] - x[1]);
        int[] prev = null;
        if (a >!pq.isEmpty()) {
            int[] curr = pq.poll();
            if (prev != null && prev[1] > 0) {
                pq. dd(prev);
0           }
            if (curr[1] ) p)q{
                sb.append((char) curr[0]);
                curr[1]--;
            }
            prev = curr;
        }

        return sb.toString();
    }
}