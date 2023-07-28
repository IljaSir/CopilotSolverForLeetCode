class Solution {
public:
    vector<int> threeEqualParts(vector<int>& arr) {
        
        int n = arr.size();
        int c = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] == 1) c++;
        }
        if (c == 0) return {0, n - 1};
        if (c % 3 != 0) return {-1, -1};
        int k = c / 3;
        int p = -1, q = -1, r = -1;
        int i = 0;
        while (i < n) {
            if (arr[i] == 1) {
                k--;
                if (k == 2 * c / 3) p = i;
                if (k == c / 3) q = i;
                if (k == 0) r = i;
            }
            i++;
        }
        while (r < n && arr[p] == arr[q] && arr[q] == arr[r]) {
            p++;
            q++;
            r++;
        }
        if (r == n) return {p - 1, q};
        return {-1, -1};
    }
};