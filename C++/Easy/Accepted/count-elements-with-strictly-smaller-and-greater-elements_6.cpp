class Solution {
public:
    int countElements(vector<int>& nums) {
        
        int cnt = 0;
        for(int i=0; i<nums.size(); i++){
            int smaller = 0, greater = 0;
            for(int j=0; j<nums.size(); j++){
                if(i==j) continue;
                if(nums[i] > nums[j]) smaller++;
                else if(nums[i] < nums[j]) greater++;
            }
            if(smaller>0 && greater>0) cnt++;
        }
        return cnt;
    }
};