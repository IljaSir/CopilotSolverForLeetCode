class Solution {
public:
    vector<double> sampleStats(vector<int>& count) {
        
        int min = 0;
        int max = 0;
        int sum = 0;
        int n = 0;
        int max_count = 0;
        int mode = 0;
        double mean = 0;
        double median = 0;
        for (int i = 0; i < count.size(); i++) {
            if (count[i] > 0) {
                if (min == 0) {
                    min = i;
                }
                max = i;
                sum += i * count[i];
                n += count[i];
                if (count[i] > max_count) {
                    max_count = count[i];
                    mode = i;
                }
            }
        }
        mean = sum / (double)n;
        int mid = n / 2;
        int mid2 = mid + 1;
        int mid_count = 0;
        int mid2_count = 0;
        for (int i = 0; i < count.size(); i++) {
            if (mid_count == 0 && mid2_count == 0) {
                if (count[i] > 0) {
                    mid_count += count[i];
                    mid2_count += count[i];
                }
            } else if (mid_count == 0 && mid2_count > 0) {
                if (count[i] > 0) {
                    mid_count += count[i];
                    if (mid2_count + count[i] > mid) {
                        mid2 = i;
                        break;
                    }
                    mid2_count += count[i];
                }
            } else if (mid_count > 0 && mid2_count == 0) {
                if (count[i] > 0) {
                    mid2_count += count[i];
                    if (mid_count + count[i] > mid) {
                        mid = i;
                        break;
                    }
                    mid_count += count[i];
                }
            } else {
                break;
            }
        }
        if (n % 2 == 0) {
            median = (mid + mid2) / 2.0;
        } else {
            median = mid;
        }
        return {min, max, mean, median, mode};
    }
};