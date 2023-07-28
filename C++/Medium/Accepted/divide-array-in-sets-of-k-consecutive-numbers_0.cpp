class Solution {
public:
    bool isPossibleDivide(vector<int>& nums, int k) {
        
        int n = nums.size();
        if (n % k != 0) return false;
        map<int, int> mp;
        for (int i = 0; i < n; i++) {
            mp[nums[i]]++;
        }
        for (auto it = mp.begin(); it != mp.end(); it++) {
            int cur = it->first;
            int cnt = it->second;
            if (cnt == 0) continue;
            for (int i = 0; i < k; i++) {
                if (mp[cur + i] < cnt) return false;
                mp[cur + i] -= cnt;
            }
        }
        return true;
    }
};