class Solution {
public:
    int findJudge(int n, vector<vector<int>>& trust) {
        
        if (trust.size() < n - 1) return -1;
        vector<int> in(n + 1);
        vector<int> out(n + 1);
        for (auto& t: trust) {
            out[t[0]]++;
            in[t[1]]++;
        }
        for (int i = 1; i <= n; i++) {
            if (in[i] == n - 1 && out[i] == 0) return i;
        }
        return -1;
    }
};