class Solution {
    public int minimumHammingDistance(int[] source, int[] target, int[][] allowedSwaps) {
        
        int n = source.length;
        UnionFind uf = new UnionFind(n);
        for(int[] allowedSwap: allowedSwaps){
            uf.union(allowedSwap[0], allowedSwap[1]);
        }
        Map<Integer, Map<Integer, Integer>> groupToNumToCount = new HashMap<>();
        for(int i = 0; i < n; i++){
            int group = uf.find(i);
            groupToNumToCount.putIfAbsent(group, new HashMap<>());
            groupToNumToCount.get(group).put(source[i], groupToNumToCount.get(group).getOrDefault(source[i], 0) + 1);
        }
        int ans = 0;
        for(int i = 0; i < n; i++){
            int group = uf.find(i);
            int num = target[i];
            if(groupToNumToCount.get(group).getOrDefault(num, 0) == 0){
                ans++;
            }else{
                groupToNumToCount.get(group).put(num, groupToNumToCount.get(group).get(num) - 1);
            }
        }
        return ans;
    }
}
    }
}