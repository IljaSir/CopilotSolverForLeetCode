class Solution {
    public double frogPosition(int n, int[][] edges, int t, int target) {
        
        if(n == 1) return 1.0;
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for(int[] edge: edges){
            map.computeIfAbsent(edge[0], k -> new HashSet<>()).add(edge[1]);
            map.computeIfAbsent(edge[1], k -> new HashSet<>()).add(edge[0]);
        }
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        double[] prob = new double[n + 1];
        Arrays.fill(prob, -1.0);
        prob[1] = 1.0;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                int cur = queue.poll();
                if(map.get(cur).size() == 1 && cur != 1){
                    prob[cur] /= 1.0;
                }else{
                    for(int next: map.get(cur)){
                        if(prob[next] == -1.0){
                            prob[next] = prob[cur] / (map.get(cur).size() - 1);
                            queue.add(next);
                        }
                    }
                }
            }
        }
        return prob[target];
    }
}