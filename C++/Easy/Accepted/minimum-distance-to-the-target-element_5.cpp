class Solution {
public:
    int getMinDistance(vector<int>& nums, int target, int start) {
        
        int dist = 1000;
        for (int i = 0; i < nums.size(); i++) {
            if (nums[i] == target) {
                dist = min(dist, abs(i - start));
            }
        }
        return dist;
    }
};