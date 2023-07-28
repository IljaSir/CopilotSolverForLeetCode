class Solution {
public:
    long long dividePlayers(vector<int>& skill) {
        
        int n = skill.size();
        sort(skill.begin(), skill.end());
        long long res = 0;
        for (int i = 0; i < n / 2; i++) {
            res += (long long)skill[i] * skill[n - i - 1];
        }
        return res;
    }
    int maxEqualSum(vector<int>& skill) {
        long long sum = accumulate(skill.begin(), skill.end(), 0LL);
        int n = skill.size();
        long long res = 0;
        for (int i = 0; i < n / 2; i++) {
            res = max(res, dividePlayers(skill));
            swap(skill[i], skill[n - i - 1]);
            res = max(res, dividePlayers(skill));
            swap(skill[i], skill[n - i - 1]);
        }
        return res;
    }
};