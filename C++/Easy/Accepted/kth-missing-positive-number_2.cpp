class Solution {
public:
    int findKthPositive(vector<int>& arr, int k) {
        
        int n = arr.size();
        int l = 0;
        int r = n;
        while (l < r) {
            int m = l + (r - l) / 2;
            if (arr[m] - m - 1 < k) {
                l = m + 1;
            } else {
                r = m;
            }
        }
        return l + k;
    }
};