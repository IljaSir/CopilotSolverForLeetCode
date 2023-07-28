class Solution {
public:
    int reachNumber(int target) {
        
        target = abs(target);
        long long sum = 0;
        int ans = 0;
        while (sum < target) {
            ans++;
            sum += ans;
        }
        while ((sum - target) % 2 != 0) {
            ans++;
            sum += ans;
        }
        return ans;
    }
};