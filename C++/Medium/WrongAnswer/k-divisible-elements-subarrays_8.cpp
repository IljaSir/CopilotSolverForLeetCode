class Solution {
public:
    int countDistinct(vector<int>& nums, int k, int p) {
        
        int n = nums.size();
        int ans = 0;
        int count = 0;
        int left = 0;
        int right = 0;
        unordered_map<int, int> map;
        while (right < n) {
            int r = nums[right];
            map[r]++;
            if (r % p == 0) {
                count++;
            }
            while (count > k) {
                int l = nums[left];
                map[l]--;
                if (l % p == 0) {
                    count--;
                }
                left++;
            }
            ans += map[r];
            right++;
        }
        return ans;
    }
};