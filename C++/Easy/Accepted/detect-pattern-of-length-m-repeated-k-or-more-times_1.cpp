class Solution {
public:
    bool containsPattern(vector<int>& arr, int m, int k) {
        
        int n = arr.size();
        for (int i = 0; i <= n - m * k; i++) {
            bool flag = true;
            for (int j = 0; j < m; j++) {
                for (int p = 1; p < k; p++) {
                    if (arr[i + j] != arr[i + j + p * m]) {
                        flag = false;
                        break;
                    }
                }
                if (!flag) break;
            }
            if (flag) return true;
        }
        return false;
    }
};