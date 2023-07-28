class Solution {
public:
    bool divideArray(vector<int>& nums) {
        
        int n = nums.size();
        if (n % 2 != 0) return false;
        unordered_map<int, int> m;
        for (int i = 0; i < n; i++) {
            m[nums[i]]++;
        }
        for (auto it = m.begin(); it != m.end(); it++) {
            if (it->second % 2 != 0) return false;
        }
        return true;
    }
};