class Solution {
public:
    long long numberOfWeeks(vector<int>& milestones) {
        
        long long sum = 0;
        long long max = 0;
        for (auto i : milestones) {
            sum += i;
            if (i > max) {
                max = i;
            }
        }
        return min(sum, max*2-1);
    }
};