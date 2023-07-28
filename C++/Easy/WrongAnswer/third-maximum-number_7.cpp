class Solution {
public:
    int thirdMax(vector<int>& nums) {
        
        set<int> s(nums.begin(), nums.end());
        if (s.size() < 3) return *s.rbegin();
        auto it = s.rbegin();
        next(it);
        next(it);
        return *it;
    }
};