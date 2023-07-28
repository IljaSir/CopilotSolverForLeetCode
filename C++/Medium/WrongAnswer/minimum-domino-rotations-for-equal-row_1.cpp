class Solution {
public:
    int minDominoRotations(vector<int>& tops, vector<int>& bottoms) {
        
        int n = tops.size();
        int cnt[7] = {0};
        for (int i = 0; i < n; ++i) {
            ++cnt[tops[i]];
            ++cnt[bottoms[i]];
        }
        int target = -1;
        for (int i = 1; i <= 6; ++i) {
            if (cnt[i] >= n) {
                target = i;
                break;
            }
        }
        if (target == -1) {
            return -1;
        }
        int result = 0;
        for (int i = 0; i < n; ++i) {
            if (tops[i] == target) {
                continue;
            }
            if (bottoms[i] == target) {
                ++result;
            } else {
                return -1;
            }
        }
        return result;
    }
};