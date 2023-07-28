class Solution {
public:
    bool isPossibleDivide(vector<int>& nums, int k) {
        
        if (nums.size() % k != 0) return false;
        map<int, int> mp;
        for (int i : nums) mp[i]++;
        for (auto it = mp.begin(); it != mp.end(); it++) {
            if (it->second > 0) {
                for (int i = 1; i < k; i++) {
                    if (mp[it->first + i] >= it->second) {
                        mp[it->first + i] -= it->second;
                    } else {
                        return false;
                    }
                }
            }
        }
        return true;
    }
};