class Solution {
    public int[] countSubgraphsForEachDiameter(int n, int[][] edges) {
        
        int[] res = new int[n-1];
        for(int mask=1; mask<(1<<n); mask++){
            if(Integer.bitCount(mask) == 1) continue;
            boolean[][] graph = new boolean[n][n];
            for(int[] e: edges){
                if((mask&(1<<e[0]-1)) > 0 && (mask&(1<<e[1]-1)) > 0){
                    graph[e[0]-1][e[1]-1] = graph[e[1]-1][e[0]-1] = true;
                }
            }
            int[] d = new int[n];
            Arrays.fill(d, -1);
            int max = 0;
            for(int i=0; i<n; i++){
                if((mask&(1<<i)) > 0){
                    Queue<Integer> q = new LinkedList<>();
                    q.offer(i);
                    d[i] = 0;
                    while(!q.isEmpty()){
                        int cur = q.poll();
                        for(int j=0; j<n; j++){
                            if(graph[cur][j] && d[j] == -1){
                                d[j] = d[cur] + 1;
                                q.offer(j);
                            }
                        }
                    }
                    max = Math.max(max, d[i]);
                }
            }
            boolean flag = true;
            for(int i=0; i<n; i++){
                if((mask&(1<<i)) > 0 && d[i] == -1){
                    flag = false;
                    break;
                }
            }
            if(flag) res[max-1]++;
        }
        return res;
    }
}