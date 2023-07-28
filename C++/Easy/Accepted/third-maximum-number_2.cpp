class Solution {
public:
    int thirdMax(vector<int>& nums) {
        
        int n = nums.size();
        set<int> s;
        for (int i = 0; i < n; ++i) {
            s.insert(nums[i]);
            if (s.size() > 3) {
                s.erase(s.begin());
            }
        }
        if (s.size() == 3) {
            return *s.begin();
        } else {
            return *s.rbegin();
        }
    }
};