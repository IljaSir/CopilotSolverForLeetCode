class Solution {
    public int numSimilarGroups(String[] strs) {
        
        int n = strs.length;
        UnionFind uf = new UnionFind(n);
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (uf.find(i) == uf.find(j)) continue;
                if (isSimilar(strs[i], strs[j])) uf.union(i, j);
            }
        }
        return uf.count;
    }

    private boolean isSimilar(String s1, String s2) {
        int diff = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                diff++;
                if (diff > 2) return false;
            }
        }
        return true;
    }

    class UnionFind {
        int[] parent;
        int[] size;
        int count;

        public UnionFind(int n) {
            parent = new int[n];
            size = new int[n];
            count = n;
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }

        public int find(int i) {
            if (parent[i] == i) return i;
            return parent[i] = find(parent[i]);
        }

        public void union(int i, int j) {
            int pi = find(i);
            int pj = find(j);
            if (pi == pj) return;
            if (size[pi] > size[pj]) {
                parent[pj] = pi;
                size[pi] += size[pj];
            } else {
                parent[pi] = pj;
                size[pj] += size[pi];
            }
            count--;
        }
    }
}