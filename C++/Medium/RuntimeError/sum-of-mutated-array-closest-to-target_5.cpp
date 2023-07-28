class Solution {
public:
    int findBestValue(vector<int>& arr, int target) {
        
        int sum = 0;
        for (int i = 0; i < arr.size(); i++) {
            sum += arr[i];
        }
        if (sum <= target) {
            return arr[arr.size() - 1];
        }
        int i = 0;
        int j = arr.size() - 1;
        while (i < j) {
            int mid = (i + j) / 2;
            int s = 0;
            for (int k = 0; k < arr.size(); k++) {
                if (k <= mid) {
                    s += arr[k];
                } else {
                    s += arr[mid];
                }
            }
            if (s >= target) {
                j = mid;
            } else {
                i = mid + 1;
            }
        }
        int s = 0;
        for (int k = 0; k < arr.size(); k++) {
            if (k <= i) {
                s += arr[k];
            } else {
                s += arr[i];
            }
        }
        if (s == target) {
            return arr[i];
        }
        int s1 = 0;
        for (int k = 0; k < arr.size(); k++) {
            if (k <= i - 1) {
                s1 += arr[k];
            } else {
                s1 += arr[i - 1];
            }
        }
        if (abs(target - s) < abs(target - s1)) {
            return arr[i];
        } else {
            return arr[i - 1];
        }
    }
};