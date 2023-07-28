class Solution {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a,b)->{
            double x = (a[0]+1.0)/(a[1]+1.0) - a[0]*1.0/a[1];
            double y = (b[0]+1.0)/(b[1]+1.0) - b[0]*1.0/b[1];
            return y-x>0?1:-1;
        });
        for(int[] c:classes){
            pq.offer(c);
        }
        while(extraStudents-->0){
            int[] c = pq.poll();
            c[0]++;
            c[1]++;
            pq.offer(c);
        }
        double sum = 0;
        while(!pq.isEmpty()){
            int[] c = pq.poll();
            sum += c[0]*1.0/c[1];
        }
        return sum/classes.length;
    }
}