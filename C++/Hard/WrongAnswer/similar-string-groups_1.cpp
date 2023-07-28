class Solution {
public:
    int numSimilarGroups(vector<string>& strs) {
        
        int n = strs.size();
        vector<int> parent(n);
        for (int i = 0; i < n; ++i) parent[i] = i;
        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                if (find(parent, i) == find(parent, j)) continue;
                if (isSimilar(strs[i], strs[j])) {
                    parent[find(parent, i)] = find(parent, j);
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            if (parent[i] == i) ans++;
        }
        return ans;
    }
    
    int find(vector<int>& parent, int i) {
        if (parent[i] == i) return i;
        return parent[i] = find(parent, parent[i]);
    }
    
    bool isSimilar(string& a, string& b) {
        int n = a.size();
        int cnt = 0;
        for (int i = 0; i < n; ++i) {
            if (a[i] != b[i]) cnt++;
        }
        return cnt == 2;
    }
};