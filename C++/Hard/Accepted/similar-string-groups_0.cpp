class Solution {
public:
    int numSimilarGroups(vector<string>& strs) {
        
        int n = strs.size();
        vector<int> parent(n);
        for (int i = 0; i < n; ++i) {
            parent[i] = i;
        }
        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                if (isSimilar(strs[i], strs[j])) {
                    int p1 = find(parent, i);
                    int p2 = find(parent, j);
                    if (p1 != p2) {
                        parent[p1] = p2;
                    }
                }
            }
        }
        int res = 0;
        for (int i = 0; i < n; ++i) {
            if (parent[i] == i) {
                ++res;
            }
        }
        return res;
    }
    
    int find(vector<int>& parent, int i) {
        if (parent[i] != i) {
            parent[i] = find(parent, parent[i]);
        }
        return parent[i];
    }
    
    bool isSimilar(string& s1, string& s2) {
        int n = s1.size();
        int cnt = 0;
        for (int i = 0; i < n; ++i) {
            if (s1[i] != s2[i]) {
                ++cnt;
            }
        }
        return cnt == 2 || cnt == 0;
    }
};