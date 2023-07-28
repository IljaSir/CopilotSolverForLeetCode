class Solution {
public:
    long long dividePlayers(vector<int>& skill) {
        
        long long ans = 0;
        int n = skill.size();
        sort(skill.begin(), skill.end());
        for (int i = 0; i < n; i += 2) {
            ans += (long long) skill[i] * skill[i + 1];
        }
        return ans;
    }
    long long dividePlayers2(vector<int>& skill) {
        long long ans = 0;
        int n = skill.size();
        sort(skill.begin(), skill.end());
        for (int i = 0; i < n; i += 2) {
            ans += (long long) skill[i] * skill[i + 1];
        }
        return ans;
    }
};