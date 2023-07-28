class Solution {
public:
    int findSpecialInteger(vector<int>& arr) {
        
        int n = arr.size();
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] == arr[n / 4]) {
                cnt++;
            }
        }
        return cnt > n / 4 ? arr[n / 4] : arr[0];
    }
};