class Solution {
public:
    vector<int> maximumBobPoints(int numArrows, vector<int>& aliceArrows) {
        
        int total = accumulate(aliceArrows.begin(), aliceArrows.end(), 0);
        vector<int> bobArrows(12, 0);
        for (int i = 0; i < 12; i++) {
            bobArrows[i] = (i + 1) * aliceArrows[i] - total;
            if (bobArrows[i] < 0) {
                bobArrows[i] = 0;
            }
        }
        return bobArrows;
    }
};