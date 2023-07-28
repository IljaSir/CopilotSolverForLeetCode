class Solution {
public:
    long long dividePlayers(vector<int>& skill) {
        
        sort(skill.begin(), skill.end());
        long long res = 0;
        for (int i = 0; i < skill.size() / 2; i++) {
            res += (long long)skill[i] * skill[skill.size() - i - 1];
        }
        return res;
    }
};