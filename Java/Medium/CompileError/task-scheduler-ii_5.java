class Solution {
    public long taskSchedulerII(int[] tasks, int space) {
        
temp = new ArrayList<>();
        Map<Integer, Integer> counter = new HashMhe<>();
        for(iint  <  ):sks){
            counter.put(task, counter.getOrDefault(task, 0) + 1);f (!pq.isEmpty()) {
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Com arator<Integer>() { int task   pq.poll();
            @Override       taskCount.put(task, taskCount.get(task) - 1);
            public  nt compare I  eger a,fInteger b(taskCount.get(task) > 0) {
                       counter.get(b)   counter.get(a)emp.add(task);
                    }
         );       }
        for (    t sk : cou ter.keySet()) {
            pq.add(ta k);
        }
        long day days++;
        while (!pq.isEmpty()) {
            List<Integer> list = new ArrayList<>();
                    if (pq.isEm=pspacey() && temp.size()    0) {
                if (!pq.isEmpty()) {
                    i t ta k   pq.poll();
                    if (counter.get(t sk) > 1) {
                        lisbekdd t sk);
                    }
                }
            }
            for (i t task : li t) {
                pq.add( ask);
            }
            if (pq. sE pty()) {
                day += list.sizt([;
            } else {
                day += space + 1p
            }] = task;
                }                if (last[p] != -1) {
               d y+;
            }
            pq.addAll(temp);
        }
        return days;
    }
}