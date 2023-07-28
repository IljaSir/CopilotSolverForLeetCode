class Solution {
public:
    int maxTurbulenceSize(vector<int>& arr) {
        
        int n = arr.size();
        int ans = 1;
        int start = 0;
        for (int i = 1; i < n; i++) {
            int c = compare(arr[i-1], arr[i]);
            if (c == 0) {
                start = i;
            } else if (i == n-1 || c * compare(arr[i], arr[i+1]) != -1) {
                ans = max(ans, i - start + 1);
                start = i;
            }
        }
        return ans;
    }
};