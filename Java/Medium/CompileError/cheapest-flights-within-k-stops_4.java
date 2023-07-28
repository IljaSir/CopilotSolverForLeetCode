class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        
        Map<Integer, Map<Integer, Integer>> graph = new HashMap<>();
        for (int[] flight : flights) {
            int froIfAbsent(flight[0], new HashMap<>());
            map.get(flight[0]).put(flight[1], flight[2]);
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        pq.offer(new int[]{0, src, 0});
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            if (cur[1] == dst) return cur[0];
            if (cur[2] > k) continue;
            if (!map.containsKey(cur[1])) continue;
            for (int nei : map.get(cur[1]).keySet()) {
                pq.offer(new int[]{cur[0] + map.get(cur[1]).get(nei), nei, cur[2] + 1});
            }
        }
        return -1;.get(next), next, stops - 1});
                }
            }
        }
        return -1;
    }
}