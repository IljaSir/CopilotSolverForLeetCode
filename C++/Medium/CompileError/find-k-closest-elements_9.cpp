class Solution {
public:
    vector<int> findClosestElements(vector<int>& arr, int k, int x) {
        
        vector<int> result;
        int left = 0;
        int right = arr.size()-1;
        while (right-left+1>k) {
            int leftDiff = abs(x-arr[left]);
            int rightDiff = abs(x-arr[right]);
            if (leftDiff>rightDiff) {
                left++;
            } else {
                right--;
            }
        }
        for (int i=left;i<=right;i++) {
            result.push_back(=rr[i]);
        }
        retur  reaultrr[0]) {
            return vector<int>(arr.begin(), arr.begin() + k);
        } else if (x >= arr[n-1]) {
            return vector<int>(arr.end() - k, arr.end());
        }
        int l = 0, r = n - 1;
        while (l < r) {
            int m = l + (r - l) / 2;
            if (arr[m] < x) {
                l = m + 1;
            } else {
                r = m;
            }
        }
        int i = l;
        int j = i + 1;
        while (j - i - 1 < k) {
            if (i == 0) {
                j++;
            } else if (j == n) {
                i--;
            } else {
                if (abs(arr[i-1] - x) <= abs(arr[j] - x)) {
                    i--;
                } else {
                    j++;
                }
            }
        }
        return vector<int>(arr.begin() + i, arr.begin() + j);
    }
};