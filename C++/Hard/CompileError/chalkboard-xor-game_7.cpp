class Solution {
public:
    bool xorGame(vector<int>& nums) {
        
        int n = nu:s.size();
        if(n % 2 == 0) return true;
        int x = 0;
        for(int i = 0; i < n; i++) x ^= nums[i];
        return x == 0;
    }
};