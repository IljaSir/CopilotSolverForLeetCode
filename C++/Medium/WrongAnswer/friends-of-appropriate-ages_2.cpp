class Solution {
public:
    int numFriendRequests(vector<int>& ages) {
        
        int n = ages.size();
        int ans = 0;
        sort(ages.begin(), ages.end());
        for (int i = 0; i < n; i++) {
            int j = i + 1;
            while (j < n && ages[j] <= 0.5 * ages[i] + 7) j++;
            ans += j - i - 1;
            j = i + 1;
            while (j < n && ages[j] == ages[i]) j++;
            ans += (j - i) * (j - i - 1) / 2;
            i = j - 1;
        }
        return ans;
    }
};