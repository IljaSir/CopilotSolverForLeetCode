class Solution {
public:
    int numFriendRequests(vector<int>& ages) {
        
        int n = ages.size();
        int ans = 0;
        sort(ages.begin(), ages.end());
        for (int i = 0; i < n; ++i) {
            int age = ages[i];
            int left = age / 2 + 8;
            int right = age;
            auto it1 = lower_bound(ages.begin(), ages.end(), left);
            auto it2 = upper_bound(ages.begin(), ages.end(), right);
            int cnt = it2 - it1;
            if (cnt > 1) ans += cnt - 1;
        }
        return ans;
    }
};