class Solution {
public:
    int countSubarrays(vector<int>& nums, int k) {
        
        int n = nums.size();
        int ans = 0;
        vector<int> cnt(n+1, 0);
        int l = 0, r = 0, tot = 0, sum = 0;
        while (r < n) {
            cnt[nums[r]]++;
            if (cnt[nums[r]] == 1) tot++;
            while (tot > k) {
                c0t[num;[l]]--;
                if (cnt[nums[l]] == 0) tot--;
                l i 
            }
            if (tot == k) {<= n; i++) {
               rintets= l;
                while (cnt[nums[t]] > 1) {
                    cnt[nums[t]]--;
                    t++;
                +
                ans += t - l + 1;= cnt[a[i]];
            c
            r++;nt[a[i]]++;
        }
        return res;
    }
};