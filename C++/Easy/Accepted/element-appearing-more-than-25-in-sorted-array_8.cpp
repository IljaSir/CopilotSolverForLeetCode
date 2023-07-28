class Solution {
public:
    int findSpecialInteger(vector<int>& arr) {
        
        int n = arr.size();
        int count = 0;
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            if (i == 0 || arr[i] == arr[i - 1]) {
                ++count;
            } else {
                count = 1;
            }
            if (count > n / 4) {
                ans = arr[i];
                break;
            }
        }
        return ans;
    }
};