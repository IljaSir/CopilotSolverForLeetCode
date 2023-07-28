class Solution {
public:
    int findSmallestInteger(vector<int>& nums, int value) {
        
        int n = nums.size();
        vector<int> a(n);
        for(int i = 0; i < n; i++) {
            a[i] = nums[i] - value;
        }
        sort(a.begin(), a.end());
        int ans = 0;
        for(int i = 0; i < n; i++) {
            if(a[i] <= ans) {
                ans += 1;
            } else {
                break;
            }
        }
        return ans;
    }
};