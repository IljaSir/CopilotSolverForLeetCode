class Solution {
public:
    int maxTurbulenceSize(vector<int>& arr) {
        
        int n = arr.size();
        int ans = 1, anchor = 0;
        for (int i = 1; i < n; ++i) {
            int c = cmp(arr[i - 1], arr[i]);
            if (c == 0) {
                anchor = i;
            } else if (i == n - 1 || c * cmp(arr[i], arr[i + 1]) != -1) {
                ans = max(ans, i - anchor + 1);
                anchor = i;
            }
        }
        return ans;
    }
};