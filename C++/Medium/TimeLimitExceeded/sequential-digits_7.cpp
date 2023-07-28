class Solution {
public:
    vector<int> sequentialDigits(int low, int high) {
        
        vector<int> res;
        int i = 1;
        while (i < 1000000000) {
            int j = i;
            int k = 0;
            while (j) {
                k = k * 10 + (j % 10);
                j /= 10;
            }
            if (k >= low && k <= high) {
                res.push_back(k);
            }
            if (i % 10 == 9) {
                i = i / 10 + 1;
            } else {
                i++;
            }
        }
        sort(res.begin(), res.end());
        return res;
    }
};