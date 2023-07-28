class Solution {
public:
    int totalFruit(vector<int>& fruits) {
        
        int n = fruits.size();
        int ans = 0;
        int i = 0;
        int j = 0;
        unordered_map<int, int> cnt;
        while (j < n) {
            cnt[fruits[j]]++;
            while (cnt.size() > 2) {
                cnt[fruits[i]]--;
                if (cnt[fruits[i]] == 0) {
                    cnt.erase(fruits[i]);
                }
                i++;
            }
            ans = max(ans, j - i + 1);
            j++;
        }
        return ans;
    }
};