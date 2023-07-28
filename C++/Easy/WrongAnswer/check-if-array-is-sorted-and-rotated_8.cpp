class Solution {
public:
    bool check(vector<int>& nums) {
        
        int N = nums.size();
        int i = 0;
        while (i < N && nums[i] == nums[0]) {
            i++;
        }
        if (i == N) {
            return true;
        }
        int step = nums[i] > nums[0] ? 1 : -1;
        i = (i + step + N) % N;
        while (i != 0 && nums[i] == nums[0]) {
            i = (i + step + N) % N;
        }
        return i == 0;
    }
};