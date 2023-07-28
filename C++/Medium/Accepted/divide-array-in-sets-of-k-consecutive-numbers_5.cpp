class Solution {
public:
    bool isPossibleDivide(vector<int>& nums, int k) {
        
        map<int, int> mp;
        for (int i = 0; i < nums.size(); i++) {
            mp[nums[i]]++;
        }
        while (!mp.empty()) {
            int start = mp.begin()->first;
            for (int i = 0; i < k; i++) {
                if (mp.find(start + i) == mp.end()) {
                    return false;
                }
                mp[start + i]--;
                if (mp[start + i] == 0) {
                    mp.erase(start + i);
                }
            }
        }
        return true;
    }
};