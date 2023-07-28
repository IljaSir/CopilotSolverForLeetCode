class Solution {
public:
    bool containsPattern(vector<int>& arr, int m, int k) {
        
        int n = arr.size();
        for (int i = 0; i < n - m * k + 1; ++i) {
            bool valid = true;
            for (int j = 0; j < m; ++j) {
                for (int l = 1; l < k; ++l) {
                    if (arr[i + j] != arr[i + j + l * m]) {
                        valid = false;
                        break;
                    }
                }
            }
            if (valid) return true;
        }
        return false;
    }
};