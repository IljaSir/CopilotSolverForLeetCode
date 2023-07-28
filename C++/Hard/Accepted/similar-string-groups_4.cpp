class Solution {
public:
    int numSimilarGroups(vector<string>& strs) {
        
        vector<int> p(strs.size(), 0);
        for (int i = 0; i < p.size(); ++i) {
            p[i] = i;
        }
        for (int i = 0; i < strs.size(); ++i) {
            for (int j = i + 1; j < strs.size(); ++j) {
                if (isSimilar(strs[i], strs[j])) {
                    int pi = find(p, i);
                    int pj = find(p, j);
                    if (pi != pj) {
                        p[pi] = pj;
                    }
                }
            }
        }
        int count = 0;
        for (int i = 0; i < p.size(); ++i) {
            if (p[i] == i) {
                ++count;
            }
        }
        return count;
    }
    bool isSimilar(const string& s1, const string& s2) {
        int count = 0;
        for (int i = 0; i < s1.size(); ++i) {
            if (s1[i] != s2[i]) {
                ++count;
            }
        }
        return count == 2 || count == 0;
    }
    int find(vector<int>& p, int i) {
        while (i != p[i]) {
            p[i] = p[p[i]];
            i = p[i];
        }
        return i;
    }
};