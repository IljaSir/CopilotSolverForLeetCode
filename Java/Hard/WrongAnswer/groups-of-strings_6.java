class Solution {
    public int[] groupStrings(String[] words) {
        
        int n = words.length;
        int[] ans = new int[]{0, 0};
        int[] parent = new int[n];
        int[] size = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (isConnected(words[i], words[j])) {
                    union(parent, size, i, j);
                }
            }
        }
        for (int i = 0; i < n; i++) {
            ans[0] = Math.max(ans[0], size[i]);
            ans[1] = Math.max(ans[1], size[find(parent, i)]);
        }
        return ans;
    }
    private boolean isConnected(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        int n = s1.length();
        int offset = s2.charAt(0) - s1.charAt(0);
        for (int i = 1; i < n; i++) {
            if (s2.charAt(i) - s1.charAt(i) != offset) {
                return false;
            }
        }
        return true;
    }
    private int find(int[] parent, int x) {
        if (x != parent[x]) {
            parent[x] = find(parent, parent[x]);
        }
        return parent[x];
    }
    private void union(int[] parent, int[] size, int x, int y) {
        int px = find(parent, x);
        int py = find(parent, y);
        if (px != py) {
            if (size[px] < size[py]) {
                int tmp = px;
                px = py;
                py = tmp;
            }
            parent[py] = px;
            size[px] += size[py];
        }
    }
}