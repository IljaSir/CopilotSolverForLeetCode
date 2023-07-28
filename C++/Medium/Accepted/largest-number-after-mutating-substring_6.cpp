class Solution {
public:
    string maximumNumber(string num, vector<int>& change) {
        
        string ans = "";
        int i = 0;
        while(i < num.size() && change[num[i] - '0'] <= num[i] - '0') ans += num[i++];
        while(i < num.size() && change[num[i] - '0'] >= num[i] - '0') ans += change[num[i++] - '0'] + '0';
        while(i < num.size()) ans += num[i++];
        return ans;
    }
};