class Solution {
public:
    vector<double> sampleStats(vector<int>& count) {
        
        int n = accumulate(count.begin(), count.end(), 0);
        int min = 0, max = 0;
        double mean = 0;
        int median = 0;
        int mode = 0;
        for (int i = 0; i < count.size(); i++) {
            if (min == 0 && count[i] > 0) {
                min = i;
            }
            if (count[i] > 0) {
                max = i;
            }
            mean += i * count[i];
            if (n % 2 == 1 && median == 0) {
                if (count[i] > n / 2) {
                    median = i;
                } else {
                    n -= count[i];
                }
            } else if (n % 2 == 0 && median == 0) {
                if (count[i] > n / 2) {
                    median = i;
                    n -= count[i];
                } else if (count[i] > n / 2 - 1) {
                    median = i;
                } else {
                    n -= count[i];
                }
            }
            if (count[i] > count[mode]) {
                mode = i;
            }
        }
        mean /= accumulate(count.begin(), count.end(), 0);
        return {min, max, mean, median, mode};
    }
};