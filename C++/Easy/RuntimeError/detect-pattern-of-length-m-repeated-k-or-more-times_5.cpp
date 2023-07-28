class Solution {
public:
    bool containsPattern(vector<int>& arr, int m, int k) {
        
        int n = arr.size();
        for (int i = 0; i < n - m; i++) {
            int j = i + m;
            int cnt = 1;
            while (j + m <= n && arr[i] == arr[j] && arr[j] == arr[j + m]) {
                cnt++;
                j += m;
            }
            if (cnt >= k) {
                return true;
            }
        }
        return false;
    }
};