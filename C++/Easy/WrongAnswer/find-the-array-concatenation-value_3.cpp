class Solution {
public:
    long long findTheArrayConcVal(vector<int>& nums) {
        
        long long ans = 0;
        while (nums.size() > 1) {
            ans += nums.front();
            ans *= 10;
            ans += nums.back();
            nums.erase(nums.begin());
            nums.erase(nums.end() - 1);
        }
        if (nums.size() == 1) {
            ans += nums.front();
        }
        return ans;
    }
};