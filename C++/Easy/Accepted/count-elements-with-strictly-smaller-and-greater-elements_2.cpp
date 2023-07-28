class Solution {
public:
    int countElements(vector<int>& nums) {
        
        int res = 0;
        for (int i = 0; i < nums.size(); i++) {
            int l = 0, r = 0;
            for (int j = 0; j < nums.size(); j++) {
                if (nums[j] < nums[i]) l++;
                else if (nums[j] > nums[i]) r++;
            }
            if (l > 0 && r > 0) res++;
        }
        return res;
    }
};