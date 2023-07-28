class Solution {
public:
    int numTimesAllBlue(vector<int>& flips) {
        
        int ans = 0;
        int max = 0;
        for (int i = 0; i < flips.size(); ++i) {
            if (flips[i] > max) max = flips[i];
            if (max == i + 1) ++ans;
        }
        return ans;
    }
};