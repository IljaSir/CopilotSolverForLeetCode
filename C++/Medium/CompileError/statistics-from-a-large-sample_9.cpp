class Solution {
public:
    vector<double> sampleStats(vector<int>& count) {
        
        int min = 0, max = 0, sum = 0, mode = 0, modeCount = 0, median = 0, medianCount = 0, medianCount2 = 0, median2 = 0;
        int totalCount = 0;
        for (int i = 0; i < count.size(); i++) {
            if (count[i] > 0) {
                if (min == 0) {
                    min = i;
                }
                max = i;
                sum += i * count[i];
                totalCount += count[i];
                if (modeCount < count[i]) {
                    mode = i;
                    modeCount = count[i];
                }
            }
        }
        for (int i = 0; i < count.size(); i++) {
            if (count[i] > 0) {
                if (medianCount < totalCount / 2 + 1) {
                    median = i;
                    medianCount += count[i];
                }
                if (medianCount2 < totalCount / 2 + 2) {
                    median2 = i;
                    medianCount2 += count[i];
                }
            }
        }
        return vector<double>{min, max, (double)sum / totalCount, totalCount % 2 == 0 ? (double)(median + median2) / 2 : median, mode};
    }
};