class Solution {
public:
    long long numberOfWeeks(vector<int>& milestones) {
        
        long long sum = 0, maxNum = 0;
        for (int i = 0; i < milestones.size(); i++) {
            sum += milestones[i];
            maxNum = max(maxNum, (long long)milestones[i]);
        }
        long long ans = min(sum - maxNum + 1, sum);
        return ans;
    }
};