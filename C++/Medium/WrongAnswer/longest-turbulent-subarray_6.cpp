class Solution {
public:
    int maxTurbulenceSize(vector<int>& arr) {
        
        int n = arr.size();
        if (n == 1) return 1;
        int ans = 1;
        int cur = 1;
        for (int i = 1; i < n; i++) {
            if (arr[i] == arr[i - 1]) {
                cur = 1;
            } else if ((i % 2 == 0 && arr[i] > arr[i - 1]) || (i % 2 == 1 && arr[i] < arr[i - 1])) {
                cur++;
            } else {
                cur = 2;
            }
            ans = max(ans, cur);
        }
        return ans;
    }
};