class Solution {
public:
    vector<double> sampleStats(vector<int>& count) {
        
        int max = -1, min = -1;
        long long sum = 0;
        int mode = 0;
        int count_sum = 0;
        for (int i = 0; i < 256; ++i) {
            if (count[i] > 0) {
                if (min == -1) {
                    min = i;
                }
                max = i;
                sum += count[i] * i;
                count_sum += count[i];
                if (count[i] > count[mode]) {
                    mode = i;
                }
            }
        }
        vector<double> result;
        result.push_back(min);
        result.push_back(max);
        result.push_back((double)sum / count_sum);
        if (count_sum % 2 == 0) {
            int count1 = 0;
            int count2 = 0;
            for (int i = 0; i < 256; ++i) {
                if (count[i] > 0) {
                    count1 += count[i];
                    if (count1 >= count_sum / 2) {
                        result.push_back(i);
                        break;
                    }
                    if (count1 == count_sum / 2) {
                        count2 = i;
                    }
                }
            }
            if (count2 > 0) {
                result.push_back((result[3] + count2) / 2.0);
            } else {
                result.push_back(result[3]);
            }
        } else {
            int count1 = 0;
            for (int i = 0; i < 256; ++i) {
                if (count[i] > 0) {
                    count1 += count[i];
                    if (count1 > count_sum / 2) {
                        result.push_back(i);
                        break;
                    }
                }
            }
        }
        result.push_back(mode);
        return result;
    }
};