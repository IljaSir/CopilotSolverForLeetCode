class Solution {
    public int scheduleCourse(int[][] courses) {
        
        Arrays.sort(courses, (a, b) -> a[1] - b[1]);
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        int time = 0;
        for (int[] c : courses) {
            pq.offer(c[0]);
            time += c[0];
            if (time > c[1]) {
                time -= pq.poll();
            }
        }
        return pq.size();
    }
}