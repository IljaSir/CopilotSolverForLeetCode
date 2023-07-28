class Solution {
    public int[] smallestMissingValueSubtree(int[] parents, int[] nums) {
        
        int n = parents.length;
        int[] ans = new int[n];
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i=0;i<n;i++){
            if(!map.containsKey(parents[i])){
                map.put(parents[i], new ArrayList<>());
            }
            map.get(parents[i]).add(i);
        }
        int[] visited = new int[n];
        dfs(map, visited, 0, nums);
        for(int i=0;i<n;i++){
            ans[i] = visited[i];
        }
        return ans;
    }
    
    public int dfs(Map<Integer, List<Integer>> map, int[] visited, int node, int[] nums){
        if(visited[node] != 0)
            return visited[node];
        int min = 1;
        if(map.containsKey(node)){
            for(int child: map.get(node)){
                int curr = dfs(map, visited, child, nums);
                if(curr == min)
                    min = curr+1;
                else if(curr < min)
                    min = curr;
            }
        }
        if(nums[node] == min)
            min = min+1;
        visited[node] = min;
        return min;
    }
}