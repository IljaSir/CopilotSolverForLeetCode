class Solution {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        
        int[][] jobs = new int[startTime.length][3];
        for (int i = 0; i < startTime.length; i++) {
            jobs[i] = new int[]{startTime[i], endTime[i], profit[i]};
        }
        Arrays.sort(jobs, (a, b) -> a[0] - b[0]);
        TreeMap<Integer, Integer> map = new TreeMap<>();
        map.put(0, 0);
        for (int[] job : jobs) {
            int curr = map.floorEntry(job[1]).getValue() + job[2];
            if (curr > map.lastEntry().getValue()) {
                map.put(job[1], curr);
            }
        }
        return map.lastEntry().getValue();
    }
}