class Solution {
public:
    int totalFruit(vector<int>& fruits) {
        
        int n = fruits.size();
        int ans = 0;
        int i = 0;
        unordered_map<int, int> m;
        for (int j = 0; j < n; ++j) {
            m[fruits[j]]++;
            while (m.size() > 2) {
                m[fruits[i]]--;
                if (m[fruits[i]] == 0) m.erase(fruits[i]);
                i++;
            }
            ans = max(ans, j - i + 1);
        }
        return ans;
    }
};