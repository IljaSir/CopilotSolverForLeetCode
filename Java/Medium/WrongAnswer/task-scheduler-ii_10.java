class Solution {
    public long taskSchedulerII(int[] tasks, int space) {
        
        // 1. count the frequency of each task
        Map<Integer, Integer> freq = new HashMap<>();
        for (int task : tasks) {
            freq.put(task, freq.getOrDefault(task, 0) + 1);
        }
        
        // 2. sort the frequency of tasks in descending order
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        pq.addAll(freq.values());
        
        // 3. maintain a window of size k, and the window contains the tasks that are cooling down
        Queue<Integer> window = new LinkedList<>();
        
        // 4. loop through the tasks
        long days = 0;
        while (!pq.isEmpty()) {
            int curFreq = pq.poll();
            window.offer(curFreq - 1);
            days++;
            if (window.size() > space) {
                int nextFreq = window.poll();
                if (nextFreq > 0) {
                    pq.offer(nextFreq);
                }
            }
            
            // 5. if the pq is empty, we need to add the remaining tasks in the window to the pq
            if (pq.isEmpty() && !window.isEmpty()) {
                days += space - window.size() + 1;
            }
        }
        return days;
    }
}