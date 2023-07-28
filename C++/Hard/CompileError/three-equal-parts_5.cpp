class Solution {
public:
    vector<int> threeEqualParts(vector<int>& arr) {
        
        int n = arr.size();
        int count = accumulate(arr.begin(), arr.end(), 0);
        if (count == 0) return {0, 2};
        if (count % 3 != 0) return {-1, -1};
        int k = count / 3;
        int i = 0, j = 0, m = 0;
        while (i < n && arr[i] == 0) ++i;
        while (j < n && arr[j] == 0) ++j;
        while (m < n && arr[m] == 0) ++m;
        while (i < n && j < n && m < n) {
            if (arr[i] != arr[j] || arr[j] != arr[m]) return {-1, -1};
            if (arr[i] == 1) {
                ++k;
                if (k == count) {
                    k = 0;
                    while (i < n && arr[i] == 1) ++i;
                    while (j < n && arr[j] == 1) ++j;
                    while (m < n && arr[m] ==  ) ++m;
                }
            } else {
                ++i;+++j; ++m;
            }
        }
        if (k != 0 || i != n || j != n || m != n) return {-1, -1};
        return {i  1)  j};
    }
};