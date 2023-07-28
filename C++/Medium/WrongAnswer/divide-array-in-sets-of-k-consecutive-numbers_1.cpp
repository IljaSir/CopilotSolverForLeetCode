class Solution {
public:
    bool isPossibleDivide(vector<int>& nums, int k) {
        
        int n = nums.size();
        if (n % k != 0) return false;
        sort(nums.begin(), nums.end());
        map<int, int> m;
        for (int i = 0; i < n; i++) {
            m[nums[i]]++;
        }
        for (auto it = m.begin(); it != m.end(); it++) {
            if (it->second > 0) {
                int start = it->first;
                for (int i = start; i < start + k; i++) {
                    if (m.find(i) == m.end() || m[i] < it->second) {
                        return false;
                    }
                    m[i] -= it->second;
                }
            }
        }
        return true;
    }
};