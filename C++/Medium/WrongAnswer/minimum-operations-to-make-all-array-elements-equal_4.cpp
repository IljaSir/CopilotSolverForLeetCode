class Solution {
public:
    vector<long long> minOperations(vector<int>& nums, vector<int>& queries) {
        
        int n = nums.size();
        int m = queries.size();
        vector<int> freq(100010, 0);
        for (int i = 0; i < n; i++) {
            freq[nums[i]]++;
        }
        vector<long long> prefix(100010, 0);
        for (int i = 1; i < 100010; i++) {
            prefix[i] = prefix[i - 1] + freq[i];
        }
        vector<long long> answer(m, 0);
        for (int i = 0; i < m; i++) {
            int x = queries[i];
            int pos = lower_bound(prefix.begin(), prefix.end(), x) - prefix.begin();
            if (pos == 100010) {
                answer[i] = 0;
            }
            else {
                answer[i] = prefix[pos] - x;
            }
        }
        return answer;
    }
};