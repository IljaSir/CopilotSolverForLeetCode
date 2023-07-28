class Solution {
public:
    vector<int> findClosestElements(vector<int>& arr, int k, int x) {
        
        int n = arr.size();
        int l = 0, r = n - 1;
        while (l < r) {
            int m = l + (r - l) / 2;
            if (arr[m] >= x) {
                r = m;
            } else {
                l = m + 1;
            }
        }
        int i = l, j = l;
        while (j - i + 1 < k) {
            if (i == 0) {
                ++j;
            } else if (j == n - 1) {
                --i;
            } else {
                if (x - arr[i - 1] <= arr[j + 1] - x) {
                    --i;
                } else {
                    ++j;
                }
            }
        }
        return vector<int>(arr.begin() + i, arr.begin() + j + 1);
    }
};