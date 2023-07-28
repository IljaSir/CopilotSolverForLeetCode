class Solution {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        
        List<Integer> res = new ArrayList<>();
        int[] inDegree = new int[n];
        for (List<Integer> edge: edges)
            inDegree[edge.get(1)]++;
        for (int i = 0; i < n; i++)
            if (inDegree[i] == 0)
                res.add(i);
        return res;
    }
}