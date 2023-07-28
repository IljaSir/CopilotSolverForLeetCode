class Solution {
public:
    vector<double> sampleStats(vector<int>& count) {
        
        vector<double> res(5, 0);
        int max = 0;
        int min = 0;
        int total = 0;
        int mode = 0;
        int median = 0;
        int sum = 0;
        int count_sum = 0;
        int count_median = 0;
        for (int i = 0; i < count.size(); ++i) {
            if (count[i] > 0) {
                min = i;
                break;
            }
        }
        for (int i = count.size() - 1; i >= 0; --i) {
            if (count[i] > 0) {
                max = i;
                break;
            }
        }
        for (int i = 0; i < count.size(); ++i) {
            if (count[i] > max) {
                mode = i;
                max = count[i];
            }
            if (count[i] > 0) {
                sum += i * count[i];
                total += count[i];
            }
        }
        for (int i = 0; i < count.size(); ++i) {
            if (count[i] > 0) {
                count_sum += count[i];
                if (count_sum > total / 2) {
                    median = i;
                    break;
                }
                if (count_sum == total / 2) {
                    for (int j = i + 1; j < count.size(); ++j) {
                        if (count[j] > 0) {
                            median = (i + j) / 2.0;
                            break;
                        }
                    }
                }
            }
        }
        res[0] = min;
        res[1] = max;
        res[2] = sum / double(total);
        res[3] = median;
        res[4] = mode;
        return res;
    }
};