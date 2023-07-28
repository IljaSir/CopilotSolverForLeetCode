class Solution {
public:
    int longestConsecutive(vector<int>& nums) {
        
        unordered_set<int> num_set;
        for(int num : nums) {
            num_set.insert(num);
        }
        int longest_streak = 0;
        for(int num : num_set) {
            if(!num_set.count(num-1)) {
                int current_num = num;
                int current_streak = 1;
                while(num_set.count(current_num+1)) {
                    current_num++;
                    current_streak++;
                }
                longest_streak = max(longest_streak, current_streak);
            }
        }
        return longest_streak;
    }
};