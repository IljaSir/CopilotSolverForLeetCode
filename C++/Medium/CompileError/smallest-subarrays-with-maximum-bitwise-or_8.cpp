class Solution {
public:
    vector<int> smallestSubarrays(vector<int>& nums) {
        
        vector<int> res(nums.size(), 0);
        int n = nums.size();
        vector<int> max_or(n, 0);
        max_or[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; --i) {
            max_or[i] = max_or[i + 1] | nums[i];
        }
        vector<int> max_or_idx(n, 0);
        max_or_idx[n - 1] = n - 1;
        for (int i = n - 2; i >= 0; --i) {
            if (max_or[i] == max_or[i + 1]) {
                max_or_idx[i] = max_or_idx[i + 1];
            } else {
                max_or_idx[i] = i;
            }
        }
        int max_bit = 0;
        for (int i = 0; i < n; ++i) {
            max_bit = max(max_bit, nums[i]);
        }
        int bit = 0;
        while (max_bit > 0) {
            max_bit >>= 1;
            bit++;
        }
        vector<int> bit_count(bit, 0);
        vector<int> bit_idx(bit, 0);
        int i = 0;
        int j = 0;
        while (i < n) {
            while (j < n && bit_count[bit - 1] == 0) {
                for (int k = 0; k < bit; ++k) {
                    if ((nums[j] & (1 << k)) > 0) {
                        if (bit_count[k] == 0) {
                            bit_idx[k] = j;
                        }
                        bit_count[k]++;
                    }
                }
                j++;
            }
            if (bit_count[bit - 1] > 0) {
                res[i] = j - i;
            }
            for (int k = 0; k < bit; ++k) {
                if ((nums[i] & (1 << k)) > 0) {
                    if (bit_count[k] == 1) {
                        res[i] = j - bit_idx[k];
                    }
                    bit_count[k]--;
                }
            }
            i++;
        }
        for (int i = 0; i < n; ++i) {
            int j
    }
};