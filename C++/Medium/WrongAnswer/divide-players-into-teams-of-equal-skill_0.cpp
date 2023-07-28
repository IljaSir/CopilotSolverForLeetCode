class Solution {
public:
    long long dividePlayers(vector<int>& skill) {
        
        int n = skill.size();
        sort(skill.begin(), skill.end());
        long long res = 0;
        for (int i = 0; i < n / 2; ++i) {
            res += (long long)skill[i] * skill[n - i - 1];
        }
        return res;
    }
    int maxSumOfTwoSubsets(vector<int>& skill) {
        int n = skill.size();
        int sum = accumulate(skill.begin(), skill.end(), 0);
        long long res = 0;
        for (int i = 1; i < (1 << n); ++i) {
            int cnt = 0;
            int s = 0;
            for (int j = 0; j < n; ++j) {
                if (i & (1 << j)) {
                    ++cnt;
                    s += skill[j];
                }
            }
            if (cnt == n / 2) {
                res = max(res, dividePlayers(skill) + s * (sum - s));
            }
        }
        return res % 1000000007;
    }
};