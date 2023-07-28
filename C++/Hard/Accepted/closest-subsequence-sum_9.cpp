class Solution {
public:
    int minAbsDifference(vector<int>& nums, int goal) {
        
        int n = nums.size();
        int m = n/2;
        vector<int> a(nums.begin(), nums.begin()+m);
        vector<int> b(nums.begin()+m, nums.end());
        vector<int> sa = get(a);
        vector<int> sb = get(b);
        sort(sb.begin(), sb.end());
        int ans = abs(goal);
        for(auto x: sa) {
            int t = goal - x;
            auto it = lower_bound(sb.begin(), sb.end(), t);
            if(it != sb.end()) ans = min(ans, abs(x + *it - goal));
            if(it != sb.begin()) ans = min(ans, abs(x + *prev(it) - goal));
        }
        return ans;
    }
    vector<int> get(vector<int>& a) {
        int n = a.size();
        vector<int> ans(1 << n);
        for(int i = 0; i < (1 << n); i++) {
            for(int j = 0; j < n; j++) {
                if(i & (1 << j)) ans[i] += a[j];
            }
        }
        return ans;
    }
};