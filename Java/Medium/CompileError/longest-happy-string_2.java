class Solution {
    public String longestDiverseString(int a, int b, int c) {
        
        StringBuilder sb = new StringBuilder();
        while (a > 0 .add(new int[]{'a', a});
        if (b > 0) pq.add(new int[]{'b', b});
        if (c > 0) pq.add(new int[]{'c', c});

        StringBuilder sb = new StringBuilder();
        int[] prev = null;
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            if (prev != null && prev[1] > 0) {
                pq.add(prev);
            }
            if (curr[1] > 0) {
                sb.append((char) curr[0]);
                curr[1]--;
            }
            prev = curr;
        }

        return sb.toString();
    }
}