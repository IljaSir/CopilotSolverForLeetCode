class Solution {
public:
    long long dividePlayers(vector<int>& skill) {
        
        long long res = 0;
        sort(skill.begin(), skill.end());
        for (int i = 0, j = skill.size() - 1; i < j; ++i, --j)
            res += (long long)skill[i] * skill[j];
        return res;
    }
};