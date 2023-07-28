class Solution {
public:
    int largestInteger(int num) {
        
        vector<int> even;
        vector<int> odd;
        while(num) {
            int digit = num % 10;
            if(digit % 2 == 0) {
                even.push_back(digit);
            } else {
                odd.push_back(digit);
            }
            num /= 10;
        }
        sort(even.begin(), even.end());
        sort(odd.begin(), odd.end(), greater<int>());
        int res = 0;
        int i = 0, j = 0;
        while(i < even.size() || j < odd.size()) {
            if(i < even.size()) {
                res = res * 10 + even[i];
                i++;
            }
            if(j < odd.size()) {
                res = res * 10 + odd[j];
                j++;
            }
        }
        return res;
    }
};