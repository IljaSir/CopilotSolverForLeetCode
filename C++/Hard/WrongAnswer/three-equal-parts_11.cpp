class Solution {
public:
    vector<int> threeEqualParts(vector<int>& arr) {
        
        int n = arr.size();
        int count = 0;
        for (int i = 0; i < n; i++) {
            count += arr[i];
        }
        if (count % 3 != 0) {
            return {-1, -1};
        }
        if (count == 0) {
            return {0, n - 1};
        }
        int i = 0;
        int j = 0;
        int k = 0;
        int part = count / 3;
        int cur = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] == 1) {
                cur++;
                if (cur == 1) {
                    j = i;
                }
                if (cur == part + 1) {
                    k = i;
                }
                if (cur == part * 2 + 1) {
                    break;
                }
            }
        }
        while (k < n && arr[j] == arr[k]) {
            j++;
            k++;
        }
        if (k == n) {
            return {j - 1, k};
        }
        return {-1, -1};
    }
};