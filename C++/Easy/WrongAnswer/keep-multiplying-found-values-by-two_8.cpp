class Solution {
public:
    int findFinalValue(vector<int>& nums, int original) {
        
        vector<int> v;
        while (true) {
            auto it = find(nums.begin(), nums.end(), original);
            if (it != nums.end()) {
                v.push_back(original);
                original *= 2;
            } else {
                break;
            }
        }
        return v.back();
    }
};