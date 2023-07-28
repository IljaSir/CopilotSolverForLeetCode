class Solution {
public:
    int findSpecialInteger(vector<int>& arr) {
        
        int n = arr.size();
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] == arr[i + 1]) {
                cnt++;
            } else {
                if (cnt > n / 4) {
                    return arr[i];
                }
                cnt = 0;
            }
        }
        return -1;
    }
};