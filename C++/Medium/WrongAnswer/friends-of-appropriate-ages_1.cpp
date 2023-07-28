class Solution {
public:
    int numFriendRequests(vector<int>& ages) {
        
        sort(ages.begin(), ages.end());
        int n = ages.size();
        int res = 0;
        int i = 0;
        while (i < n) {
            int j = i + 1;
            while (j < n && ages[j] == ages[i]) j++;
            int count = j - i;
            res += count * (count - 1);
            i = j;
        }
        i = 0;
        while (i < n) {
            int j = i + 1;
            while (j < n && ages[j] <= ages[i] / 2 + 7) j++;
            res += (j - i - 1) * (i + 1);
            i = j;
        }
        return res;
    }
};