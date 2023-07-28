class Solution {
public:
    vector<int> maximumBobPoints(int numArrows, vector<int>& aliceArrows) {
        
        int sum = 0;
        for (int i = 0; i < 12; ++i) {
            sum += aliceArrows[i];
        }
        vector<int> bobArrows(12, 0);
        int diff = numArrows - sum;
        int i = 11;
        while (diff > 0) {
            if (aliceArrows[i] == 0) {
                bobArrows[i] = 1;
                diff--;
            }
            i--;
        }
        return bobArrows;
    }
};