class Solution {
    public int minimumHammingDistance(int[] source, int[] target, int[][] allowedSwaps) {
        
        int n = source.length;
        int[] parent = new int[n];
        for(int i = 0; i < n; i++){
            parent[i] = i;
        }
        for(int[] swap : allowedSwaps){
            int x = find(parent, swap[0]);
            int y = find(parent, swap[1]);
            if(x != y){
                parent[x] = y;
            }
        }
        Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
        for(int i = 0; i < n; i++){
            int p = find(parent, i);
            map.putIfAbsent(p, new HashMap<>());
            map.get(p).put(source[i], map.get(p).getOrDefault(source[i], 0) + 1);
        }
        int res = 0;
        for(int i = 0; i < n; i++){
            int p = find(parent, i);
            Map<Integer, Integer> m = map.get(p);
            m.put(target[i], m.getOrDefault(target[i], 0) - 1);
            if(m.get(target[i]) < 0){
                res++;
            }
        }
        return res;
    }
    private int find(int[] parent, int x){
        if(parent[x] != x){
            parent[x] = find(parent, parent[x]);
        }
        return parent[x];
    }
}