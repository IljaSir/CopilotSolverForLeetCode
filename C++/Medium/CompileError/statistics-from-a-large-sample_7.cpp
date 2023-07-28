class Solution {
public:
    vector<double> sampleStats(vector<int>& count) {
        
        int min = 0, max = 0;
        long long sum = 0;
        int mode = 0;
        int modeCount = 0;
        int totalCount = 0;
        int medianIndex = 0;
        int median1 = 0;
        int median2 = 0;
        for (int i = 0; i < count.size(); i++) {
            if (count[i] > 0) {
                if (min == 0) {
                    min = i;
                }
                max = i;
                sum += i * count[i];
                if (count[i] > modeCount) {
                    modeCount = count[i];
                    mode = i;
                }
                totalCount += count[i];
            }
        }
        medianIndex = totalCount / 2;
        int count1 = 0;
        for (int i = 0; i < count.size(); i++) {
            if (count[i] > 0) {
                if (count1 + count[i] > medianIndex) {
                    median1 = i;
                    if (totalCount % 2 == 0) {
                        if (count1 + count[i] == medianIndex + 1) {
                            median2 = i;
                            break;
                        } else {
                            median2 = i - 1;
                            break;
                        }
                    } else {
                        break;
                    }
                } else {
                    count1 += count[i];
                }
            }
        }
        double mean = (double)sum / totalCount;
        double median = median1;
        if (median2 != 0) {
            median = (median1 + median2) / 2.0;
        }
        return {min, max, mean, median, mode};
    }
};