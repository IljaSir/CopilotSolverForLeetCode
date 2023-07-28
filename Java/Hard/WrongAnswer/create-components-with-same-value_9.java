class Solution {
    public int componentValue(int[] nums, int[][] edges) {
        
        int n = nums.length;
        int[] parent = new int[n];
        for(int i = 0; i < n; i++){
            parent[i] = i;
        }
        int[] sum = new int[n];
        for(int i = 0; i < n; i++){
            sum[i] = nums[i];
        }
        for(int[] edge : edges){
            int root1 = findRoot(edge[0], parent);
            int root2 = findRoot(edge[1], parent);
            if(root1 != root2){
                parent[root2] = root1;
                sum[root1] += sum[root2];
            }
        }
        int root = findRoot(0, parent);
        for(int i = 0; i < n; i++){
            if(sum[i] != sum[root]){
                return -1;
            }
        }
        int count = 0;
        for(int i = 0; i < n; i++){
            if(parent[i] == i){
                count++;
            }
        }
        return n - count;
    }
    private int findRoot(int x, int[] parent){
        if(parent[x] != x){
            parent[x] = findRoot(parent[x], parent);
        }
        return parent[x];
    }
}