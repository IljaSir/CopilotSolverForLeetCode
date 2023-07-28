class Solution {
public:
    bool containsPattern(vector<int>& arr, int m, int k) {
        
        int n = arr.size();
        for (int i = 0; i <= n - m; i++) {
            int count = 1;
            for (int j = i + m; j <= n - m; j++) {
                bool same = true;
                for (int p = 0; p < m; p++) {
                    if (arr[i + p] != arr[j + p]) {
                        same = false;
                        break;
                    }
                }
                if (same) {
                    count++;
                    if (count == k) return true;
                } else {
                    break;
                }
            }
        }
        return false;
    }
};