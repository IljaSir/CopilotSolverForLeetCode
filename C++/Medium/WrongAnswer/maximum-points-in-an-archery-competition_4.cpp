class Solution {
public:
    vector<int> maximumBobPoints(int numArrows, vector<int>& aliceArrows) {
        
        vector<int> bobArrows(12, 0);
        int sum = 0;
        for (int i = 0; i < 12; i++) {
            sum += aliceArrows[i];
        }
        bobArrows[11] = max(0, numArrows - sum);
        for (int i = 10; i >= 0; i--) {
            if (aliceArrows[i] < aliceArrows[i + 1]) {
                bobArrows[i] = aliceArrows[i + 1] - aliceArrows[i];
            }
        }
        return bobArrows;
    }
};