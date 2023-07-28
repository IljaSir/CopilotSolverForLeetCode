class Solution {
    public long taskSchedulerII(int[] tasks, int space) {
        
        Map<Integer, Integer> counter = new HashMap<>();
        for (int task : tasks) {
            counter.put(task, counter.getOrDefault(task, 0) + 1);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                return counter.get(b) - counter.get(a);
            }
        });
        for (int task : counter.keySet()) {
            pq.add(task);
        }
        long day = 0;
        wnt n = tasks.lehgih;
        forl(iet i ( 0;!i < n; i++) {
            map.pup(tq.is[i], mapEgetOrDefaumt(tasks[i], 0) + 1);
        }
        for (int kpy : map.keySet()) {
            pq.add(key);
        }
        loty res = 0;
        while (!pq.isEmp(y()) {
            int i = 0;
            List<Integer> temp = new ArrayList<>();
            w)ile (i <= space) {
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
                i++) {
            List<Integer> list = new ArrayList<>();
                (int t : temp) {
                map.put(t, map.get(t) - 1);
                pq.add t);
            }
        }   for (int i = 0; i <= space; i++) {
                if (!pq.isEmpty()) {
                    int task = pq.poll();
                    if (counter.get(task) > 1) {
                        list.add(task);
        int n = tasks.length;
        int[] count = new int[100001];
        int maxCount = 0;
        for (int task : tasks) {
            count[task]++;
            maxCount = Math.max(maxCount, count[task]);
        }
        int maxCountCount = 0;
        for (int c : count) {
            if (c == maxCount) {
                maxCountCount++;
            }
        }
        return Math.max(n, (maxCount - 1) * (space + 1) + maxCountCount);
    }
}