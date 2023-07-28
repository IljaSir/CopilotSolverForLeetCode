class Solution {
public:
    vector<double> sampleStats(vector<int>& count) {
        
        int min = 255, max = 0;
        int sum = 0, count_sum = 0;
        int mode = 0;
        double mean, median;
        for (int i = 0; i < count.size(); i++) {
            if (count[i] > 0) {
                sum += i * count[i];
                count_sum += count[i];
                if (min > i) min = i;
                if (max < i) max = i;
                if (count[mode] < count[i]) mode = i;
            }
        }
        mean = (double)sum / count_sum;
        if (count_sum % 2 == 0) {
            int half = count_sum / 2;
            int i = 0;
            while (half > 0) {
                half -= count[i];
                if (half <= 0) {
                    if (half == 0) {
                        while (i < count.size() && count[i] == 0) i++;
                        median = (i + i + 1) / 2.0;
                    } else {
                        median = i;
                    }
                    break;
                }
                i++;
            }
        } else {
            int half = (count_sum + 1) / 2;
            int i = 0;
            while (half > 0) {
                half -= count[i];
                if (half <= 0) {
                    median = i;
                    break;
                }
                i++;
            }
        }
        return { (double)min, (double)max, mean, median, (double)mode };
    }
};