class Solution {
    public int minimumRounds(int[] tasks) {
        
        Map<Integer, Integer> taskMap = new HashMap<>();
        for (int task : tasks) {
            taskMap.put(task, taskMap.getOrDefault(task, 0) + 1);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for (int task : taskMap.keySet()) {
            pq.offer(task);
        }
        int rounds = 0;
        while (!pq.isEmpty()) {
            int task = pq.poll();
            int count = taskMap.get(task);
            if (count == 0) {
                continue;
            }
            rounds++;
            count--;
            if (count > 0) {
                taskMap.put(task, count);
                pq.offer(task);
            }
            int nextTask = task + 1;
            count = taskMap.getOrDefault(nextTask, 0);
            if (count > 0) {
                count--;
                taskMap.put(nextTask, count);
                pq.offer(nextTask);
            }
        }
        return rounds;
    }
}