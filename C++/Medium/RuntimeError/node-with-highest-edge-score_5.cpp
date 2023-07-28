class Solution {
public:
    int edgeScore(vector<int>& edges) {
        
        int n = edges.size();
        vector<int> in(n, 0);
        for (int i = 0; i < n; ++i) {
            ++in[edges[i]];
        }
        vector<int> score(n, 0);
        for (int i = 0; i < n; ++i) {
            score[edges[i]] += i;
        }
        int res = 0;
        for (int i = 0; i < n; ++i) {
            if (in[i] == 0) {
                continue;
            }
            if (score[i] > score[res]) {
                res = i;
            } else if (score[i] == score[res]) {
                res = min(res, i);
            }
        }
        return res;
    }
};