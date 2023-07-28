class Solution {
public:
    int reinitializePermutation(int n) {
        
        vector<int> perm(n);
        for (int i = 0; i < n; i++) {
            perm[i] = i;
        }
        vector<int> arr(n);
        int ans = 0;
        do {
            ans++;
            for (int i = 0; i < n; i++) {
                if (i % 2 == 0) {
                    arr[i] = perm[i / 2];
                } else {
                    arr[i] = perm[n / 2 + (i - 1) / 2];
                }
            }
            perm = arr;
        } while (arr != vector<int>(n));
        return ans;
    }
};