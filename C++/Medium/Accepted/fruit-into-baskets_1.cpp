class Solution {
public:
    int totalFruit(vector<int>& fruits) {
        
        int n = fruits.size();
        int l = 0, r = 0, res = 0;
        unordered_map<int, int> m;
        while (r < n) {
            m[fruits[r]]++;
            while (m.size() > 2) {
                m[fruits[l]]--;
                if (m[fruits[l]] == 0) {
                    m.erase(fruits[l]);
                }
                l++;
            }
            res = max(res, r - l + 1);
            r++;
        }
        return res;
    }
};