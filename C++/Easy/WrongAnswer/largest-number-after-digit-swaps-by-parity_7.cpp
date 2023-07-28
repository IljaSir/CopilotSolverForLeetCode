class Solution {
public:
    int largestInteger(int num) {
        
        vector<int> odd;
        vector<int> even;
        int ret = 0;
        while(num) {
            int digit = num % 10;
            if(digit % 2 == 0) {
                even.push_back(digit);
            } else {
                odd.push_back(digit);
            }
            num /= 10;
        }
        sort(odd.begin(), odd.end(), greater<int>());
        sort(even.begin(), even.end(), greater<int>());
        int i = 0;
        int j = 0;
        while(i < odd.size() || j < even.size()) {
            if(i < odd.size() && j < even.size()) {
                if(odd[i] > even[j]) {
                    ret = ret * 10 + odd[i];
                    i++;
                } else {
                    ret = ret * 10 + even[j];
                    j++;
                }
            } else if(i < odd.size()) {
                ret = ret * 10 + odd[i];
                i++;
            } else {
                ret = ret * 10 + even[j];
                j++;
            }
        }
        return ret;
    }
};