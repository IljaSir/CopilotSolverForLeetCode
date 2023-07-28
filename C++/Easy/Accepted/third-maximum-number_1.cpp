class Solution {
public:
    int thirdMax(vector<int>& nums) {
        
        set<int> s;
        for (int i = 0; i < nums.size(); i++) {
            s.insert(nums[i]);
        }
        if (s.size() < 3) {
            return *s.rbegin();
        } else {
            auto it = s.rbegin();
            it++;
            it++;
            return *it;
        }
    }
};