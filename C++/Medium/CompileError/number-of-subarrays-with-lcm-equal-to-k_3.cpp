class Solution {
public:
    int subarrayLCM(vector<int>& nums, int k) {
        
        int n = nums.size();
        vector<int> f(n + 1);
        f[0] = 1;
        for (int i = 0; i < n; ++i) {
            f[i + 1] = f[i] * nums[i] / gcd(f[i], nums[i]);
            if (f[i + 1] > k) {
                return 0;
            }
        }
        int ans = 0;
        for (int i = 0, j = n - 1; i <= j; ++i, --j) {
            if (f[i] == k) {
                ++ans;
            }
            if (i < j && f[j] == k) {
                ++ans;
            }
        }
        return ans;
    }
    int numberOfSubarrays(vector<int>& nums, int k) {
        vector<int> odd;
        int n = nums.size();
        for (int i = 0; i < n; ++i) {
            if (nums[i] & 1) {
                odd.push_back(i);
            }
        }
        int ans = 0;
        for (int i = 0; i + k - 1 < odd.size(); ++i) {
            int l = i == 0 ? odd[i] + 1 : odd[i] - odd[i - 1];
            int r = i + k - 1 == odd.size() - 1 ? n - odd[i + k - 1] : odd[i + k] - odd[i + k - 1];
            ans += l * r;
        }
        return ans;
    }
    int numberOfSubarrays(vector<int>& nums, int k) {
        int n = nums.size();
        vector<int> odd;
        odd.push_back(-1);
        for (int i = 0; i < n; ++i) {
            if (nums[i] & 1) {
                odd.push_back(i);
            }
        }
        odd.push_back(n);
        int ans = 0;
        for (int i = 1; i + k < odd.size(); ++i) {
            ans += (odd[i] - odd[i - 1]) * (odd[i + k] - odd[i + k - 1]);
        }
        return ans;
    }
};