class Solution {
    public int secondMinimum(int n, int[][] edges, int time, int change) {
        
        int[][] graph = new int[n][n];
        for(int i = 0; i < n; i++)
            Arrays.fill(graph[i], -1);
        for(int[] edge : edges){
            graph[edge[0] - 1][edge[1] - 1] = time;
            graph[edge[1] - 1][edge[0] - 1] = time;
        }
        int[] minTime = new int[n];
        Arrays.fill(minTime, Integer.MAX_VALUE);
        minTime[0] = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        while(!queue.isEmpty()){
            int cur = queue.poll();
            for(int i = 0; i < n; i++){
                if(graph[cur][i] != -1){
                    int next = (minTime[cur] / change + 1) * change;
                    if(minTime[i] > next + graph[cur][i]){
                        minTime[i] = next + graph[cur][i];
                        queue.offer(i);
                    }
                }
            }
        }
        int min = minTime[n - 1];
        int secondMin = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++){
            if(minTime[i] != min && minTime[i] < secondMin)
                secondMin = minTime[i];
        }
        return secondMin;
    }
}