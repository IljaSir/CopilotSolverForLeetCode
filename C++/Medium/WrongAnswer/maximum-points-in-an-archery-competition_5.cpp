class Solution {
public:
    vector<int> maximumBobPoints(int numArrows, vector<int>& aliceArrows) {
        
        vector<int> bobArrows(12);
        int score = 0;
        for (int i = 0; i < 12; i++) {
            bobArrows[i] = numArrows - aliceArrows[i];
            score += i * aliceArrows[i];
        }
        int maxScore = score;
        for (int i = 11; i >= 0; i--) {
            if (bobArrows[i] == 0) continue;
            int tmp = score;
            for (int j = 11; j >= 0; j--) {
                if (bobArrows[j] == 0) continue;
                if (j > i) {
                    tmp += (j - i) * bobArrows[i];
                    tmp -= (j - i) * bobArrows[j];
                } else if (j < i) {
                    tmp -= (i - j) * bobArrows[i];
                    tmp += (i - j) * bobArrows[j];
                }
                if (tmp > maxScore) {
                    maxScore = tmp;
                    bobArrows[i]--;
                    bobArrows[j]++;
                } else {
                    tmp = score;
                }
            }
        }
        return bobArrows;
    }
};