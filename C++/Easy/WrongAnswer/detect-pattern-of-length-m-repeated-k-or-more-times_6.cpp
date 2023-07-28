class Solution {
public:
    bool containsPattern(vector<int>& arr, int m, int k) {
        
        int n = arr.size();
        for (int i = 0; i <= n - m * k; ++i) {
            int j = i + m;
            for (int t = 0; t < k - 1; ++t) {
                if (arr[i] != arr[j]) {
                    break;
                }
                j += m;
            }
            if (j == i + m * k) {
                return true;
            }
        }
        return false;
    }
};