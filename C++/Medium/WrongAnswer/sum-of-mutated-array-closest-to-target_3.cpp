class Solution {
public:
    int findBestValue(vector<int>& arr, int target) {
        
        int sum = 0;
        int max = 0;
        for (int i = 0; i < arr.size(); i++) {
            sum += arr[i];
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        if (sum == target) {
            return max;
        }
        // binary search
        int l = 0;
        int r = max;
        int mid;
        int res = 0;
        int diff = INT_MAX;
        while (l <= r) {
            mid = (l + r) / 2;
            int newSum = 0;
            for (int i = 0; i < arr.size(); i++) {
                if (arr[i] > mid) {
                    newSum += mid;
                } else {
                    newSum += arr[i];
                }
            }
            if (abs(newSum - target) < diff) {
                res = mid;
                diff = abs(newSum - target);
            }
            if (newSum == target) {
                return mid;
            } else if (newSum > target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return res;
    }
};