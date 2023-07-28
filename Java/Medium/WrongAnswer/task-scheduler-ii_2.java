class Solution {
    public long taskSchedulerII(int[] tasks, int space) {
        
        Map<Integer, Integer> map = new HashMap<>();
        for (int t : tasks) {
            map.put(t, map.getOrDefault(t, 0) + 1);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> map.get(b) - map.get(a));
        pq.addAll(map.keySet());
        int max = map.get(pq.peek());
        int count = 0;
        while (!pq.isEmpty() && map.get(pq.peek()) == max) {
            pq.poll();
            count++;
        }
        return Math.max(tasks.length, (max - 1) * (space + 1) + count);
    }
}