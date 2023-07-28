class Solution {
public:
    long long minimumRemoval(vector<int>& beans) {
        
        sort(beans.begin(), beans.end());
        long long sum = 0;
        for (auto& i : beans) {
            sum += i;
        }
        
        long long minSum = 0;
        for (int i = 0; i < beans.size(); i++) {
            sum -= beans[i];
            minSum += sum;
        }
        return minSum;
    }
};