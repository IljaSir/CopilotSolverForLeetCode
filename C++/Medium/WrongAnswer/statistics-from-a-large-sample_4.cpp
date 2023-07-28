class Solution {
public:
    vector<double> sampleStats(vector<int>& count) {
        
        vector<double> res;
        int max = 0, min = 255, sum = 0, mode = 0, cnt = 0;
        double mean = 0, median = 0;
        for (int i = 0; i < count.size(); ++i) {
            if (count[i] > 0) {
                if (min > i) min = i;
                if (max < i) max = i;
                sum += i * count[i];
                if (mode < count[i]) {
                    mode = count[i];
                    cnt = i;
                }
            }
        }
        mean = (double)sum / sum;
        int mid = sum / 2;
        for (int i = 0; i < count.size(); ++i) {
            if (count[i] > 0) {
                if (mid > count[i]) {
                    mid -= count[i];
                } else if (mid == count[i]) {
                    median = (double)i;
                    mid -= count[i];
                } else {
                    median = (double)i;
                    break;
                }
            }
        }
        res.push_back(min);
        res.push_back(max);
        res.push_back(mean);
        res.push_back(median);
        res.push_back(cnt);
        return res;
    }
};