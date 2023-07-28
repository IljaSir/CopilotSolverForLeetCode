class Solution {
public:
    vector<int> maximumBobPoints(int numArrows, vector<int>& aliceArrows) {
        
        vector<int> bobArrows(12, 0);
        for (int i = 0; i < 12; ++i) {
            bobArrows[i] = numArrows - aliceArrows[i];
        }
        return bobArrows;
    }
};