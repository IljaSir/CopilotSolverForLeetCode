class Solution {
public:
    string maximumNumber(string num, vector<int>& change) {
        
        int i = 0;
        while (i < num.size()) {
            if (change[num[i] - '0'] > num[i] - '0') {
                break;
            }
            i++;
        }
        while (i < num.size() && change[num[i] - '0'] >= num[i] - '0') {
            num[i] = change[num[i] - '0'] + '0';
            i++;
        }
        return num;
    }
};