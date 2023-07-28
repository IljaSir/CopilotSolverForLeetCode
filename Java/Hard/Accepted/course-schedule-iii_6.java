class Solution {
    public int scheduleCourse(int[][] courses) {
        
        // sort by lastDay
        Arrays.sort(courses, (a, b) -> a[1] - b[1]);
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        int time = 0;
        for (int[] course : courses) {
            int duration = course[0];
            int lastDay = course[1];
            if (time + duration <= lastDay) {
                pq.offer(duration);
                time += duration;
            } else if (!pq.isEmpty() && pq.peek() > duration) {
                time += duration - pq.poll();
                pq.offer(duration);
            }
        }
        return pq.size();
    }
}