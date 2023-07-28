class Solution {
public:
    vector<int> threeEqualParts(vector<int>& arr) {
        
        int n = arr.size();
        int cnt = 0;
        for (int i = 0; i < n; ++i) {
            if (arr[i] == 1) ++cnt;
        }
        if (cnt == 0) return {0, n - 1};
        if (cnt % 3 != 0) return {-1, -1};
        int p1 = -1, p2 = -1, p3 = -1;
        int cnt1 = 0;
        for (int i = 0; i < n; ++i) {
            if (arr[i] == 1) {
                ++cnt1;
                if (cnt1 == 1) p1 = i;
                if (cnt1 == cnt / 3 + 1) p2 = i;
                if (cnt1 == cnt / 3 * 2 + 1) p3 = i;
            }
        }
        while (p3 < n && arr[p1] == arr[p2] && arr[p2] == arr[p3]) {
            ++p1, ++p2, ++p3;
        }
        if (p3 == n) return {p1 - 1, p2};
        return {-1, -1};
    }
};