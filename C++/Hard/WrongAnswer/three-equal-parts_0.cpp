class Solution {
public:
    vector<int> threeEqualParts(vector<int>& arr) {
        
        int n = arr.size();
        int sum = accumulate(arr.begin(), arr.end(), 0);
        if (sum % 3 != 0) return {-1, -1};
        if (sum == 0) return {0, n - 1};
        int k = sum / 3;
        int i = 0, j = n - 1;
        while (k) {
            if (arr[i] == 1) k--;
            i++;
        }
        while (k) {
            if (arr[j] == 1) k--;
            j--;
        }
        vector<int> a = {0, i - 1}, b = {i, j}, c = {j + 1, n - 1};
        while (a[1] < n && b[1] < n && c[1] < n && arr[a[0]] == arr[b[0]] && arr[b[0]] == arr[c[0]]) {
            a[0]++; a[1]++;
            b[0]++; b[1]++;
            c[0]++; c[1]++;
        }
        if (a[1] == n && b[1] == n && c[1] == n) return {a[1] - 1, b[1]};
        return {-1, -1};
    }
};