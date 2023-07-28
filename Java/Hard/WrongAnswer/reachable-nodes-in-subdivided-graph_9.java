class Solution {
    public int reachableNodes(int[][] edges, int maxMoves, int n) {
        
        int[][] graph = new int[n][n];
        for(int i=0;i<edges.length;i++){
            graph[edges[i][0]][edges[i][1]] = edges[i][2];
            graph[edges[i][1]][edges[i][0]] = edges[i][2];
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->b[1]-a[1]);
        pq.offer(new int[]{0,maxMoves});
        boolean[] visited = new boolean[n];
        int res = 0;
        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            if(visited[cur[0]]) continue;
            visited[cur[0]] = true;
            res++;
            for(int i=0;i<n;i++){
                if(graph[cur[0]][i]==0) continue;
                if(cur[1]>graph[cur[0]][i] && !visited[i]){
                    pq.offer(new int[]{i,cur[1]-graph[cur[0]][i]-1});
                }
                graph[i][cur[0]] -= Math.min(cur[1], graph[cur[0]][i]);
                res += Math.min(cur[1], graph[cur[0]][i]);
            }
        }
        return res;
    }
}