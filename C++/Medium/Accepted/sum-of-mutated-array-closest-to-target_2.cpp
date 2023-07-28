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
        if (sum <= target) {
            return max;
        }
        int l = 0;
        int r = max;
        while (l < r) {
            int mid = (l + r) / 2;
            int newSum = 0;
            for (int i = 0; i < arr.size(); i++) {
                if (arr[i] > mid) {
                    newSum += mid;
                } else {
                    newSum += arr[i];
                }
            }
            if (newSum < target) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        int s1 = 0;
        for (int i = 0; i < arr.size(); i++) {
            if (arr[i] > l - 1) {
                s1 += l - 1;
            } else {
                s1 += arr[i];
            }
        }
        int s2 = 0;
        for (int i = 0; i < arr.size(); i++) {
            if (arr[i] > l) {
                s2 += l;
            } else {
                s2 += arr[i];
            }
        }
        return abs(s1 - target) <= abs(s2 - target) ? l - 1 : l;
    }
};