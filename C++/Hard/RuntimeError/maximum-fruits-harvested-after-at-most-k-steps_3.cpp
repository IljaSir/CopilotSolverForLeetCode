class Solution {
public:
    int maxTotalFruits(vector<vector<int>>& fruits, int startPos, int k) {
        
        int n = fruits.size();
        int i = startPos, j = startPos;
        int cur = 0;
        int ans = 0;
        unordered_map<int, int> m;
        while (i >= 0 || j < n) {
            int l = i >= 0 ? fruits[i][0] : INT_MIN;
            int r = j < n ? fruits[j][0] : INT_MAX;
            if (cur <= k && (l >= startPos - k && l <= startPos + k || r >= startPos - k && r <= startPos + k)) {
                if (l < r) {
                    cur += startPos - l;
                    m[fruits[i][1]]++;
                    i--;
                } else {
                    cur += r - startPos;
                    m[fruits[j][1]]++;
                    j++;
                }
            } else {
                if (l >= startPos - k && l <= startPos + k) {
                    cur += startPos - l;
                    m[fruits[i][1]]++;
                    i--;
                } else {
                    cur += r - startPos;
                    m[fruits[j][1]]++;
                    j++;
                }
            }
            if (cur > k) {
                if (l >= startPos - k && l <= startPos + k) {
                    cur -= startPos - l;
                    m[fruits[i + 1][1]]--;
                    if (m[fruits[i + 1][1]] == 0) {
                        m.erase(fruits[i + 1][1]);
                    }
                    i++;
                } else {
                    cur -= r - startPos;
                    m[fruits[j - 1][1]]--;
                    if (m[fruits[j - 1][1]] == 0) {
                        m.erase(fruits[j - 1][1]);
                    }
                    j--;
                }
            }
            int t = 0;
            for (auto& p : m) {
                t += p.second;
            }
            ans = max(ans, t);
        }
        return ans;
    }
};