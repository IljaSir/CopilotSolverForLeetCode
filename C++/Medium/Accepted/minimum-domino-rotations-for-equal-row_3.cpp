class Solution {
public:
    int minDominoRotations(vector<int>& tops, vector<int>& bottoms) {
        
        int n = tops.size();
        vector<int> t(7, 0), b(7, 0), same(7, 0);
        for (int i = 0; i < n; i++) {
            t[tops[i]]++;
            b[bottoms[i]]++;
            if (tops[i] == bottoms[i]) same[tops[i]]++;
        }
        
        int res = INT_MAX;
        for (int i = 1; i <= 6; i++) {
            if (t[i] + b[i] - same[i] == n) {
                res = min(res, min(t[i], b[i]) - same[i]);
            }
        }
        return res == INT_MAX ? -1 : res;
    }
};