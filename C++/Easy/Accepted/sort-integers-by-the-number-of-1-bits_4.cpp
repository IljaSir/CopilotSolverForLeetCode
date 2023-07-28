class Solution {
public:
    vector<int> sortByBits(vector<int>& arr) {
        
        sort(arr.begin(), arr.end(), [](int a, int b) {
            int cntA = 0, cntB = 0;
            for (int i = 0; i < 14; i++) {
                if (a & (1 << i)) cntA++;
                if (b & (1 << i)) cntB++;
            }
            if (cntA == cntB) {
                return a < b;
            } else {
                return cntA < cntB;
            }
        });
        return arr;
    }
};