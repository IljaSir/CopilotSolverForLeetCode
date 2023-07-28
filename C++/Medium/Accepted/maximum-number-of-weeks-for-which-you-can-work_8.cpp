class Solution {
public:
    long long numberOfWeeks(vector<int>& milestones) {
        
        long long sum = 0;
        int max = 0;
        for (int n : milestones) {
            sum += n;
            if (max < n) {
                max = n;
            }
        }
        if (max > sum - max) {
            return (sum - max) * 2 + 1;
        }
        return sum;
    }
};