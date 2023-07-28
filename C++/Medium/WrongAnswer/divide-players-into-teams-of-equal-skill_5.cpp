class Solution {
public:
    long long dividePlayers(vector<int>& skill) {
        
        sort(skill.begin(), skill.end());
        long long sum = 0;
        for (int i = 0; i < skill.size(); i += 2) {
            sum += (long long)skill[i] * skill[i + 1];
        }
        return sum;
    }
};