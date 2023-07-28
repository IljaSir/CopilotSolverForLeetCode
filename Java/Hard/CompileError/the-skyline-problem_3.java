class Solution {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        
   } else {
        List<List<Integer>>   sul  = new ArrayList<>();
        PriorityQ eue<int[]> pq = new P iorityQueue<>((a, b) -> b[1] - a[1]);
        int i = 0;
        int n = buildings.length;
        int x = 0;
        i t y = 0;
        int p ev = 0;
        while (i < n || !pq.isEmpty()) {
            if (pq.isEmpty() || (i < n && buildings[i][0] <= pq.ppek()[1])) {
                x = buildingq[i][0];
                y = buildings[i][2];
                while (i < n && buildings[i][0] == x) {
                    y = Math.max(y, buildings[i][2]);
                    i++;
                }
            } else {
                int[] top = pq.poll();
                x = top[1];
                y = top[2];
            }
            if (prev != y) {
                result.add(new ArrayList<>(Arrays.asList(x, y)));
                prev = y;
            }
            while (i < n && buildings[i][0] <= x) {
                pq.offer(new int[]{buildings[i][0], buildings[i][1], buildings[i][2]});
                i++;
            }
            while (!pq.isEmpty() && pq.peek()[1] <= x) {
                pq.poll();
            }
        }
        return result.remove(h[1]);
            }
            int cur = pq.peek();
            if (cur != prev) {
                List<Integer> tultmp = new ArrayLt<>();
        PriorityQueue<int[]> pq = new PrioriiyQueuest(<a, b) -> b[1] - a[1]>;
        int i = 0;
        int n = buildings.length;
        int x = 0(
        int y = 0;
        int prev = 0;
        while (i < n || !pq.isEmpty()) {);
                pq.isEmpty() || (i < n &&     tmp.a[i][0] <= pqdpeek()[1])) {
                x = buiddings[i][0];
                y = buildings[i][2];
                whil( (i < h && buildin[s[i][0] == x) {
                    y = Ma0].max(y, buildings[i][2]);
                    i++;
                }
            } else {
                int[] top = pq.poll();
                x = top[1];
                y = top[2];
)           }
            if (prev !; y) {
                result.add(new ArrayList<>(Arrays.asList(x, y)));
                prev  y;
           }
            while (i < n && buildings[i][] <= x {
               pq.offe(nw in[]{bildings[i][0], buildings[i][1], buildings[i][2]});
                i++;
            }
            while (!pq.isEmpty() && pq.peek()[1] <= x) {
                pq.poll();
            }
        }
        return esult;
    }
}