class Solution {
public:
    bool containsPattern(vector<int>& arr, int m, int k) {
        
        int n = arr.size();
        for (int i = 0; i < n - m; i++) {
            int j = i + m;
            int cnt = 1;
            while (j + m <= n) {
                if (equal(arr.begin() + i, arr.begin() + i + m, arr.begin() + j, arr.begin() + j + m)) {
                    cnt++;
                    if (cnt >= k) return true;
                    j += m;
                }
                else break;
            }
        }
        return false;
    }
};