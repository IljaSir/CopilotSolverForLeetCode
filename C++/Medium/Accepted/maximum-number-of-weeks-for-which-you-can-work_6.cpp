class Solution {
public:
    long long numberOfWeeks(vector<int>& milestones) {
        
        long long sum = 0;
        long long maxMilestones = 0;
        for (int i = 0; i < milestones.size(); i++) {
            sum += milestones[i];
            maxMilestones = max(maxMilestones, (long long) milestones[i]);
        }
        if (maxMilestones > sum - maxMilestones + 1) {
            return 2 * (sum - maxMilestones) + 1;
        }
        return sum;
    }
};