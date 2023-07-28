class Solution {
public:
    int numPairsDivisibleBy60(vector<int>& time) {
        
        int cnt = 0;
        int n = time.size();
        vector<int> hash(60, 0);
        for(int i = 0; i < n; i++) {
            hash[time[i] % 60]++;
        }
        for(int i = 1; i < 30; i++) {
            cnt += hash[i] * hash[60 - i];
        }
        cnt += hash[0] * (hash[0] - 1) / 2;
        cnt += hash[30] * (hash[30] - 1) / 2;
        return cnt;
    }
};