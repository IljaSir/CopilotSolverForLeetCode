class Solution {
public:
    int minAbsDifference(vector<int>& nums, int goal) {
        
        int n = nums.size();
        vector<int> l(n/2), r(n-n/2);
        for(int i = 0; i < n/2; ++i) l[i] = nums[i];
        for(int i = n/2; i < n; ++i) r[i-n/2] = nums[i];
        vector<int> ls, rs;
        for(int i = 0; i < (1<<l.size()); ++i) {
            int sum = 0;
            for(int j = 0; j < l.size(); ++j) {
                if(i & (1<<j)) sum += l[j];
            }
            ls.push_back(sum);
        }
        for(int i = 0; i < (1<<r.size()); ++i) {
            int sum = 0;
            for(int j = 0; j < r.size(); ++j) {
                if(i & (1<<j)) sum += r[j];
            }
            rs.push_back(sum);
        }
        sort(ls.begin(), ls.end());
        sort(rs.begin(), rs.end());
        int ans = INT_MAX;
        for(int i = 0; i < ls.size(); ++i) {
            int sum = ls[i];
            int j = lower_bound(rs.begin(), rs.end(), goal-sum) - rs.begin();
            if(j < rs.size()) ans = min(ans, abs(sum+rs[j]-goal));
            if(j > 0) ans = min(ans, abs(sum+rs[j-1]-goal));
        }
        return ans;
    }
};