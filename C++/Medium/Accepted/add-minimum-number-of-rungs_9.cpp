class Solution {
public:
    int addRungs(vector<int>& rungs, int dist) {
        
        int n = rungs.size();
        int c = 0;
        for (int i = 0; i < n; i++) {
            int h = rungs[i];
            if (i > 0) {
                h -= rungs[i-1];
            }
            if (h > dist) {
                int d = h / dist;
                if (h % dist == 0) {
                    d--;
                }
                c += d;
            }
        }
        return c;
    }
};