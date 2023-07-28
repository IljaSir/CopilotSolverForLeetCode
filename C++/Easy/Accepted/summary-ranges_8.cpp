class Solution {
public:
    vector<string> summaryRanges(vector<int>& nums) {
        
        vector<string> res;
        int len = nums.size();
        int i = 0;
        while(i < len){
            int a = nums[i];
            while(i < len - 1 && nums[i] == nums[i + 1] - 1){
                i++;
            }
            int b = nums[i];
            if(a == b){
                res.push_back(to_string(a));
            }else{
                res.push_back(to_string(a) + "->" + to_string(b));
            }
            i++;
        }
        return res;
    }
};