class Solution {
public:
    int addRungs(vector<int>& rungs, int dist) {
        
        int n = rungs.size();
        int res = 0;
        int last = 0;
        for (int i = 0; i < n; i++) {
            res += (rungs[i] - last - 1) / dist;
            last = rungs[i];
        }
        return res;
    }
};