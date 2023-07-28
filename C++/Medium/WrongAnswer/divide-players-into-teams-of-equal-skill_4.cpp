class Solution {
public:
    long long dividePlayers(vector<int>& skill) {
        
        sort(skill.begin(), skill.end());
        long long res = 0;
        for (int i = 0; i < skill.size() / 2; i++) {
            res += skill[i] * skill[skill.size() - i - 1];
        }
        return res;
    }
    int maxEqualSum(vector<int>& nums) {
        int sum = 0;
        for (int num : nums) sum += num;
        int res = 0;
        for (int i = 0; i < nums.size() - 1; i++) {
            sum -= nums[i];
            if (sum == nums[i]) res = max(res, sum);
        }
        return res;
    }
    int maxEqualSum2(vector<int>& nums) {
        unordered_map<int, int> mp;
        int sum = 0;
        int res = 0;
        for (int i = 0; i < nums.size(); i++) {
            sum += nums[i];
            if (sum == 0) res = max(res, i + 1);
            if (mp.count(sum)) res = max(res, i - mp[sum]);
            else mp[sum] = i;
        }
        return res;
    }
    int maxEqualSum3(vector<int>& nums) {
        unordered_map<int, int> mp;
        int sum = 0;
        int res = 0;
        mp[0] = -1;
        for (int i = 0; i < nums.size(); i++) {
            sum += nums[i];
            if (mp.count(sum)) res = max(res, i - mp[sum]);
            else mp[sum] = i;
        }
        return res;
    }
    int maxEqualSum4(vector<int>& nums) {
        unordered_map<int, int> mp;
        int sum = 0;
        int res = 0;
        mp[0] = -1;
        for (int i = 0; i < nums.size(); i++) {
            sum += nums[i];
            if (mp.count(sum)) res = max(res, i - mp[sum]);
            mp[sum] = i;
        }
        return res;
    }
};