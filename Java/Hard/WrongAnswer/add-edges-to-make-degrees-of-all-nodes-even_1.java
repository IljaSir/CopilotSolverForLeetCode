class Solution {
    public boolean isPossible(int n, List<List<Integer>> edges) {
        
        int[] degree = new int[n + 1];
        for (List<Integer> edge : edges) {
            degree[edge.get(0)]++;
            degree[edge.get(1)]++;
        }
        int odd = 0;
        for (int i = 1; i <= n; i++) {
            if (degree[i] % 2 == 1) {
                odd++;
            }
        }
        if (odd == 0) {
            return true;
        }
        if (odd != 2) {
            return false;
        }
        Set<Integer> set = new HashSet<>();
        for (List<Integer> edge : edges) {
            int a = edge.get(0);
            int b = edge.get(1);
            if (degree[a] % 2 == 1 && degree[b] % 2 == 1) {
                set.add(a);
                set.add(b);
            }
        }
        if (set.size() != 2) {
            return false;
        }
        return true;
    }
}