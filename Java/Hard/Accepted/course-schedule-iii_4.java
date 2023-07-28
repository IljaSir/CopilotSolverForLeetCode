class Solution {
    public int scheduleCourse(int[][] courses) {
        
        Arrays.sort(courses, (a, b) -> a[1] - b[1]);
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> b - a);
        int time = 0;
        for (int[] c : courses) {
            time += c[0];
            queue.offer(c[0]);
            if (time > c[1]) {
                time -= queue.poll();
            }
        }
        return queue.size();
    }
}