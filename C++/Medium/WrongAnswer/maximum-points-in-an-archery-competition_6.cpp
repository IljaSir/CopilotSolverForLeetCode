class Solution {
public:
    vector<int> maximumBobPoints(int numArrows, vector<int>& aliceArrows) {
        
        vector<int> bobArrows(12, 0);
        int total = 0;
        for (int i = 0; i < 12; ++i) {
            int diff = numArrows - aliceArrows[i];
            if (diff >= 0) {
                bobArrows[i] = diff;
                total += diff;
            }
        }
        if (total > numArrows) {
            int diff = total - numArrows;
            for (int i = 11; i >= 0; --i) {
                if (bobArrows[i] > 0) {
                    int d = min(bobArrows[i], diff);
                    bobArrows[i] -= d;
                    diff -= d;
                    if (diff == 0) {
                        break;
                    }
                }
            }
        }
        return bobArrows;
    }
};