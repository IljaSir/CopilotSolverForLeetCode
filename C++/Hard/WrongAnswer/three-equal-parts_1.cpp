class Solution {
public:
    vector<int> threeEqualParts(vector<int>& arr) {
        
        int n = arr.size();
        int sum = accumulate(arr.begin(), arr.end(), 0);
        if (sum % 3 != 0) {
            return {-1, -1};
        }
        if (sum == 0) {
            return {0, n - 1};
        }
        int k = sum / 3;
        int i = 0;
        while (arr[i] == 0) {
            i++;
        }
        int j = i + 1;
        while (arr[j] == 1) {
            j++;
        }
        int l = j;
        while (arr[l] == 0) {
            l++;
        }
        int m = l + 1;
        while (arr[m] == 1) {
            m++;
        }
        int r = m;
        while (arr[r] == 0) {
            r++;
        }
        if (r != n) {
            return {-1, -1};
        }
        while (m < n && arr[m] == arr[i]) {
            i++;
            m++;
        }
        if (m != n) {
            return {-1, -1};
        }
        while (l < n && arr[l] == arr[j]) {
            j++;
            l++;
        }
        if (l != n) {
            return {-1, -1};
        }
        return {i - 1, j};
    }
};