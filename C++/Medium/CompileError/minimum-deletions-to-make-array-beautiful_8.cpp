class Solution {
public:
    int minDeletion(vector<int>& nums) {
        
        int n = nums.size();
        int ans = 0;
        for(int i = 1; i < n; ++i) {
            if(nums[i] == nums[i - 1]) {
                ans++;
                if(i < n - 1 && nums[i + 1] != nums[i - 1]) {
                    nums[i] = nums[i - 1] + 1;
                }
            }
        }
        return ans;
    }
    int minimumDeletions(string s) {
        int n = s.size();
        vector<int> a(n), b(n);
        for(int i = 0; i < n; ++i) {
            a[i] = (s[i] == 'a');
            b[i] = (s[i] == 'b');
        }
        for(int i = n - 2; i >= 0; --i) {
            a[i] += a[i + 1];
            b[i] += b[i + 1];
        }
        int ans = a[0] + b[0];
        for(int i = 0; i < n; ++i) {
            ans = min(ans, a[i] + b[i] - (s[i] == 'a'));
        }
        return ans;
    }
    int minimumDeletions(string s) {
        int n = s.size();
        vector<int> a(n), b(n);
        for(int i = 0; i < n; ++i) {
            a[i] = (s[i] == 'a');
            b[i] = (s[i] == 'b');
        }
        for(int i = n - 2; i >= 0; --i) {
            a[i] += a[i + 1];
            b[i] += b[i + 1];
        }
        int ans = a[0] + b[0];
        for(int i = 0; i < n; ++i) {
            ans = min(ans, a[i] + b[i] - (s[i] == 'a'));
        }
        return ans;
    }
};