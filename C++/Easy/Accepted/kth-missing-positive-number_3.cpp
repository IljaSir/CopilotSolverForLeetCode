class Solution {
public:
    int findKthPositive(vector<int>& arr, int k) {
        
        int n = arr.size();
        int left = 0;
        int right = n;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] - (mid + 1) < k) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left + k;
    }
};