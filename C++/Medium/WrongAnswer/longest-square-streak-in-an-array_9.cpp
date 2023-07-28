class Solution {
public:
    int longestSquareStreak(vector<int>& nums) {
        
        int n = nums.size();
        int maxStreak = 0;
        for(int i=0; i<n; i++){
            int streak = 1;
            int curr = nums[i];
            int prev = nums[i];
            for(int j=i+1; j<n; j++){
                if(nums[j] == curr*curr && nums[j] != prev){
                    streak++;
                    prev = curr;
                    curr = nums[j];
                }
            }
            maxStreak = max(maxStreak, streak);
        }
        return maxStreak >= 2 ? maxStreak : -1;
    }
};