class Solution {
public:
    int reinitializePermutation(int n) {
        
        vector<int> perm(n);
        for (int i = 0; i < n; ++i) {
            perm[i] = i;
        }
        int count = 0;
        vector<int> arr(n);
        while (true) {
            for (int i = 0; i < n; ++i) {
                if (i % 2 == 0) {
                    arr[i] = perm[i / 2];
                } else {
                    arr[i] = perm[n / 2 + (i - 1) / 2];
                }
            }
            perm = arr;
            ++count;
            if (check(perm)) {
                break;
            }
        }
        return count;
    }
    bool check(const vector<int>& perm) {
        for (int i = 0; i < perm.size(); ++i) {
            if (perm[i] != i) {
                return false;
            }
        }
        return true;
    }
};