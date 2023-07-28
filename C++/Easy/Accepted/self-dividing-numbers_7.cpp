class Solution {
public:
    vector<int> selfDividingNumbers(int left, int right) {
        
        vector<int> ans;
        for (int i = left; i <= right; ++i) {
            int j = i;
            while (j > 0) {
                int d = j % 10;
                if (d == 0 || i % d != 0) {
                    break;
                }
                j /= 10;
            }
            if (j == 0) {
                ans.push_back(i);
            }
        }
        return ans;
    }
};