class Solution {
public:
    int largestInteger(int num) {
        
        vector<int> odd;
        vector<int> even;
        while (num) {
            int digit = num % 10;
            if (digit & 1) {
                odd.push_back(digit);
            } else {
                even.push_back(digit);
            }
            num /= 10;
        }
        sort(odd.begin(), odd.end());
        sort(even.begin(), even.end());
        int ans = 0;
        int idx = 0;
        while (idx < odd.size()) {
            ans = ans * 10 + odd[idx++];
        }
        idx = 0;
        while (idx < even.size()) {
            ans = ans * 10 + even[idx++];
        }
        return ans;
    }
};