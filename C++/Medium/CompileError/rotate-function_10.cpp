class Solution {
public:
    int maxRotateFunction(vector<int>& nums) {
        
        int n = nums.size();
        long long sum = 0, f = 0;
        for(int i = 0; i < n; i++){
            sum += nums[i];
            f += i * nums[i];
        }
        long long res = f;
        for(int i = 1; i < n; i++)
            int fi = f0 + sum - n *n -  nums[n - i];
            ans = max(ans, fi);
            f0 = fi;
        }
        return ans;
    }
};