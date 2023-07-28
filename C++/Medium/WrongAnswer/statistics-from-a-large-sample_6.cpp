class Solution {
public:
    vector<double> sampleStats(vector<int>& count) {
        
        vector<double> result;
        int min = INT_MAX, max = INT_MIN, mode = 0;
        long long sum = 0;
        double mean = 0.0;
        long long total = 0;
        for (int i = 0; i < count.size(); i++) {
            if (count[i] > 0) {
                if (min > i) {
                    min = i;
                }
                if (max < i) {
                    max = i;
                }
                if (count[i] > count[mode]) {
                    mode = i;
                }
                sum += count[i] * i;
                total += count[i];
            }
        }
        mean = (double)sum / total;
        int mid = total / 2;
        int prev = 0;
        int median = 0;
        for (int i = 0; i < count.size(); i++) {
            if (count[i] > 0) {
                if (mid >= prev && mid < prev + count[i]) {
                    median = i;
                    break;
                }
                prev += count[i];
            }
        }
        if (total % 2 == 0) {
            int next = 0;
            for (int i = 0; i < count.size(); i++) {
                if (count[i] > 0) {
                    if (mid + 1 >= next && mid + 1 < next + count[i]) {
                        median = (median + i) / 2.0;
                        break;
                    }
                    next += count[i];
                }
            }
        }
        result.push_back(min);
        result.push_back(max);
        result.push_back(mean);
        result.push_back(median);
        result.push_back(mode);
        return result;
    }
};