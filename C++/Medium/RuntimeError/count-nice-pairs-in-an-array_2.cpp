class Solution {
public:
    int countNicePairs(vector<int>& nums) {
        
        unordered_map<int, int> m;
        int res = 0;
        for (int n : nums) {
            int r = rev(n);
            res += m[n - r];
            m[n - r]++;
        }
        return res % 1000000007;
    }
    
    int rev(int n) {
        int r = 0;
        while (n) {
            r = r * 10 + n % 10;
            n /= 10;
        }
        return r;
    }
};