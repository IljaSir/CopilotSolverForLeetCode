class Solution {
public:
    long long dividePlayers(vector<int>& skill) {
        
        int n = skill.size();
        int sum = accumulate(skill.begin(), skill.end(), 0);
        if (sum % (n / 2) != 0) return -1;
        int target = sum / (n / 2);
        sort(skill.begin(), skill.end());
        long long ans = 0;
        for (int i = 0; i < n; i += 2) {
            ans += 1ll * skill[i] * skill[i + 1];
        }
        return ans;
    }
};