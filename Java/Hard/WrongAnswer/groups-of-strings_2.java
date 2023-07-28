class Solution {
    public int[] groupStrings(String[] words) {
        
        int[] ans = new int[2];
        int n = words.length;
        int[] parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (isConnected(words[i], words[j])) {
                    union(parent, i, j);
                }
            }
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int p = find(parent, i);
            map.put(p, map.getOrDefault(p, 0) + 1);
        }
        int max = 0;
        for (int key : map.keySet()) {
            max = Math.max(max, map.get(key));
        }
        ans[0] = map.size();
        ans[1] = max;
        return ans;
    }
    private boolean isConnected(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        int n = s1.length();
        int diff = s2.charAt(0) - s1.charAt(0);
        for (int i = 1; i < n; i++) {
            if ((s2.charAt(i) - s1.charAt(i) + 26) % 26 != diff) {
                return false;
            }
        }
        return true;
    }
    private void union(int[] parent, int i, int j) {
        int p1 = find(parent, i);
        int p2 = find(parent, j);
        if (p1 != p2) {
            parent[p1] = p2;
        }
    }
    private int find(int[] parent, int i) {
        if (i != parent[i]) {
            parent[i] = find(parent, parent[i]);
        }
        return parent[i];
    }
}