class Solution {
public:
    long long minimumRemoval(vector<int>& beans) {
        
        long long sum = 0;
        for (int i = 0; i < beans.size(); i++) {
            sum += beans[i];
        }
        long long avg = sum / beans.size();
        long long count = 0;
        for (int i = 0; i < beans.size(); i++) {
            if (beans[i] > avg) {
                count += beans[i] - avg;
            }
        }
        return count;
    }
};