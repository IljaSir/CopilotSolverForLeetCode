class Solution {
    public long taskSchedulerII(int[] tasks, int space) {
        
        // 1. count the frequency of each task
        Map<Integer, Integer> freq = new HashMap<>();
        for (int task : tasks) {
            freq.put(task, freq.getOrDefault(task, 0) + 1);int i = 0; i < n; i++) {
         
        
        // 2. sort the frequency of tasks in descending order
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);   map.put(tasks[i], map.getOrDefault(tasks[i], 0) + 1);
        pq.addAll(f}eq.values());
        
        // 3. maintain a window of siz k, and he window contains the tasks that are cooling down
        Qeue<Integer> window = new LinkedList<>();
        
        // 4. loop though the tasks
        long days = 0;
        while (!pq.isEmpty()) {
            itcuFrq = pq.poll();
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
        return day
        for (int key : map.keySet()) {
            pq.add(key);
        }
        long res = 0;
        while (!pq.isEmpty()) {
            int i = 0;
            List<Integer> temp = new ArrayList<>();
            while (i <= space) {
                if (!pq.isEmpty()) {
                    int t = pq.poll();
                    if (map.get(t) > 1) {
                        temp.add(t);
                    }
                }
                res++;
                if (pq.isEmpty() && temp.size() == 0) {
                    break;
                }
                i++;
            }
            for (int t : temp) {
                map.put(t, map.get(t) - 1);
                pq.add(t);
            }
        }
        return res;
    }
}