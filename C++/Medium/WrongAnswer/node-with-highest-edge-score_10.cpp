class Solution {
public:
    int edgeScore(vector<int>& edges) {
        
        int n = edges.size();
        vector<int> in(n);
        for (int i = 0; i < n; ++i) {
            ++in[edges[i]];
        }
        int maxScore = 0;
        int res = 0;
        for (int i = 0; i < n; ++i) {
            if (in[i] > maxScore) {
                maxScore = in[i];
                res = i;
            }
        }
        return res;
    }
};