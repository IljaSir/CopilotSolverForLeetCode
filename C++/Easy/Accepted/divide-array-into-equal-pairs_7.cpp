class Solution {
public:
    bool divideArray(vector<int>& nums) {
        
        int n = nums.size();
        if (n % 2 == 1) return false;
        unordered_map<int, int> m;
        for (int i = 0; i < n; i++) {
            m[nums[i]]++;
        }
        for (auto it = m.begin(); it != m.end(); it++) {
            if (it->second % 2 == 1) return false;
        }
        return true;
    }
    bool canReorderDoubled(vector<int>& nums) {
        sort(nums.begin(), nums.end());
        vector<int> pos, neg;
        for (int i = 0; i < nums.size(); i++) {
            if (nums[i] >= 0) pos.push_back(nums[i]);
            else neg.push_back(nums[i]);
        }
        if (!divideArray(pos)) return false;
        if (!divideArray(neg)) return false;
        return true;
    }
};