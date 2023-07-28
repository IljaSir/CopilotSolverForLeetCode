class Solution {
public:
    long long numberOfWeeks(vector<int>& milestones) {
        
        long long sum = 0;
        int max = 0;
        for (int i = 0; i < milestones.size(); i++) {
            sum += milestones[i];
            if (max < milestones[i]) {
                max = milestones[i];
            }
        }
        if (sum - max < max) {
            return sum - max;
        }
        return (sum - max) * 2 + 1;
    }
};