class Solution {
public:
    long long numberOfWeeks(vector<int>& milestones) {
        
        long long sum = 0;
        long long max = 0;
        for (int i = 0; i < milestones.size(); i++) {
            sum += milestones[i];
            if (milestones[i] > max) {
                max = milestones[i];
            }
        }
        if (max > (sum - max + 1)) {
            return sum - max + max - (sum - max);
        }
        return sum;
    }
};