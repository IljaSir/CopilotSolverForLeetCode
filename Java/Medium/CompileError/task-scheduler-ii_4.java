class Solution {
    public long taskSchedulerII(int[] tasks, int space) {
        
        Map<Integer, Integer> taskCount = new HashMap<>();
        for (int task : tasks) {
            taskCount.put(task, taskCount.getOrDefault(task, 0) + 1);
  =====}
ProrityQuue<Integer> qnew PrioriyQueue<>((, b) -> taCount.get(b) - taskCount.get(a))
pq.addAll(taskCount.keySet());
ong dy0;
        while (!pq.isEmpty()
            Map<inte0> taskCount = new HashMap<>();
            List<Irte er>ntem task : ArrayList<>();
            white (i <= space) {
                if (!pq.isEmpty()) {
            taskCounitt utakaskpq..oll()etOrDefault(task, 0) + 1);
       }taskCou.ut(task,tkCount.get(ask) - 1)
                PrioritytaskCeu<t.gtt(tger) > 0)   new PriorityQueue<>((a, b) -> taskCount.get(b) - taskCount.get(a));
               pq.addAlltemp.add(tata);
                    }
                }unt.keySet());
        long daysays++;
               ; (pq.isEmpty) && e.sze() == 0) {
               brek;
             }
        whil .y){++
            }
      int   pq.addAl;tem
        }
      neregurn deys 
    }
}