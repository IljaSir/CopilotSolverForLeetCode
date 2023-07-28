class Solution {
public:
    int maxTotalFruits(vector<vector<int>>& fruits, int startPos, int k) {
        
        int n = fruits.size();
        int left = startPos, right = startPos;
        int ans = 0;
        int sum = 0;
        unordered_map<int, int> mp;
        while (right < n && right - left < k) {
            sum += fruits[right][1];
            mp[fruits[right][0]] += fruits[right][1];
            ans = max(ans, sum);
            right++;
        }
        while (right < n) {
            sum += fruits[right][1];
            mp[fruits[right][0]] += fruits[right][1];
            ans = max(ans, sum);
            right++;
            while (left < right && mp.size() > 2) {
                sum -= mp[fruits[left][0]];
                mp[fruits[left][0]]--;
                if (mp[fruits[left][0]] == 0) {
                    mp.erase(fruits[left][0]);
                }
                left++;
            }
        }
        return ans;
    }
};