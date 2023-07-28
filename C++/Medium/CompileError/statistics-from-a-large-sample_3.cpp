class Solution {
public:
    vector<double> sampleStats(vector<int>& count) {
        
        int sum = 0, min = 0, max = 0, mode = 0, mode_count = 0, median_count = 0;
        double mean = 0.0, median = 0.0;
        for (int i = 0; i < count.size(); ++i) {
            sum += count[i];
            if (count[i] > 0) {
                if (min == 0) min = i;
                max = i;
            }
            if (count[i] > mode_count) {
                mode = i;
                mode_count = count[i];
            }
        }
        mean = sum * 1.0 / 256;
        median_count = sum / 2;
        int i = 0;
        for (; i < count.size(); ++i) {
            median_count -= count[i];
            if (median_count <= 0) break;
        }
        if (sum % 2 == 0) {
            median = i;
            if (median_count < 0) {
                while (count[i] == 0) ++i;
                median = (median + i) / 2.0;
            }
        } else {
            median = i;
        }
        return {min, max, mean, median, mode};
    }
};