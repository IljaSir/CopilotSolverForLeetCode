class Solution {
    public int scheduleCourse(int[][] courses) {
        
        int n = courses.length;
        // sort by end time
        Arrays.sort(courses, (a, b) -> a[1] - b[1]);
        // max heap
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        int time = 0;
        for (int i = 0; i < n; i++) {
            time += courses[i][0];
            pq.offer(courses[i][0]);
            if (time > courses[i][1]) {
                time -= pq.poll();
            }
        }
        return pq.size();
    }
}