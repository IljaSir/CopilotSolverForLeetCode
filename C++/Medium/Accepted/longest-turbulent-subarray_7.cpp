class Solution {
public:
    int maxTurbulenceSize(vector<int>& arr) {
        
        int n = arr.size();
        int ans = 1;
        int cnt = 1;
        for (int i = 1; i < n; i++) {
            if (arr[i] == arr[i-1]) {
                cnt = 1;
            } else if (i == 1 || arr[i] > arr[i-1] == arr[i-1] > arr[i-2]) {
                cnt = 2;
            } else {
                cnt++;
            }
            ans = max(ans, cnt);
        }
        return ans;
    }
};