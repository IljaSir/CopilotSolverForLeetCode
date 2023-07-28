class Solution {
public:
    int shipWithinDays(vector<int>& weights, int days) {
        
        int max = 0;
        int sum = 0;
        for (int i = 0; i < weights.size(); i++) {
            sum += weights[i];
            if (max < weights[i])
                max = weights[i];
        }
        int min = sum / days;
        if (min < max)
            min = max;
        while (true) {
            int d = 1;
            int s = 0;
            for (int i = 0; i < weights.size(); i++) {
                s += weights[i];
                if (s > min) {
                    d++;
                    s = weights[i];
                }
            }
            if (d <= days)
                return min;
            min++;
        }
    }
};