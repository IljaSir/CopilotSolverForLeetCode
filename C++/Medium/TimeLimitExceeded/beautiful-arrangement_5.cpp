class Solution {
public:
    int countArrangement(int n) {
        
        vector<int> nums(n);
        for (int i = 0; i < n; ++i) nums[i] = i + 1;
        int ans = 0;
        do {
            bool ok = true;
            for (int i = 0; i < n; ++i) {
                if ((nums[i] % (i + 1) != 0) && ((i + 1) % nums[i] != 0)) {
                    ok = false;
                    break;
                }
            }
            if (ok) ans++;
        } while (next_permutation(nums.begin(), nums.end()));
        return ans;
    }
};