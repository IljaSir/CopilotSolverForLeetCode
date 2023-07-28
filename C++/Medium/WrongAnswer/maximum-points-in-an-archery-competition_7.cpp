class Solution {
public:
    vector<int> maximumBobPoints(int numArrows, vector<int>& aliceArrows) {
        
        vector<int> bobArrows(12);
        int aliceTotal = 0, bobTotal = 0;
        for (int i = 0; i < 12; ++i) {
            int alice = aliceArrows[i];
            int bob = min(numArrows - alice, numArrows - aliceTotal - bobTotal);
            aliceTotal += alice;
            bobTotal += bob;
            bobArrows[i] = bob;
        }
        return bobArrows;
    }
};