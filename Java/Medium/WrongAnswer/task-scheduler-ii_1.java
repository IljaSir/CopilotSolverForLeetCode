class Solution {
    public long taskSchedulerII(int[] tasks, int space) {
        
        Map<Integer, Integer> map = new HashMap<>();
        for (int task : tasks) {
            map.put(task, map.getOrDefault(task, 0) + 1);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> map.get(b) - map.get(a));
        pq.addAll(map.keySet());
        int maxFreq = map.get(pq.peek());
        int maxCount = 0;
        while (!pq.isEmpty() && map.get(pq.peek()) == maxFreq) {
            pq.poll();
            maxCount++;
        }
        return Math.max(tasks.length, (maxFreq - 1) * (space + 1) + maxCount);
    }
}