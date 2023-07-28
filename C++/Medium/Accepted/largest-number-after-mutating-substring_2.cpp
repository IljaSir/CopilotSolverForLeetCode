class Solution {
public:
    string maximumNumber(string num, vector<int>& change) {
        
        bool changed = false;
        for (int i = 0; i < num.size(); i++) {
            if (num[i] - '0' < change[num[i] - '0']) {
                num[i] = change[num[i] - '0'] + '0';
                changed = true;
            } else if (changed && num[i] - '0' > change[num[i] - '0']) {
                break;
            }
        }
        return num;
    }
};