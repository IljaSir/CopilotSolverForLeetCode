class Solution {
    public long taskSchedulerII(int[] tasks, int space) {
        
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < tasks.length; i++) {
            map.put(tasks[i], map.getOrDefault(tasks[i], 0) + 1);
        }
        List<Integer> list = new ArrayList<>(map.values());
        Collections.sort(list);
        int max = list.get(list.size() - 1);
        int count = 0;
        for (int i = list.size() - 1; i >= 0; i--) {
            if (list.get(i) == max) {
                count++;
            }
        }
        return Math.max(tasks.length, (long) (max - 1) * (space + 1) + count);
    }
}