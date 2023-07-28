class Solution {
public:
    long long numberOfWeeks(vector<int>& milestones) {
        
        long long sum = 0;
        int max = 0;
        for (int i = 0; i < milestones.size(); i++) {
            sum += milestones[i];
            if (max < milestones[i])
                max = milestones[i];
        }
        long long res = sum - max;
        if (res >= max)
            return sum;
        else
            return 2 * res + 1;
    }
};