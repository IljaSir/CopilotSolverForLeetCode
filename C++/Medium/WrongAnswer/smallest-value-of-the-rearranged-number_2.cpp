class Solution {
public:
    long long smallestNumber(long long num) {
        
        string s = to_string(num);
        sort(s.begin(), s.end());
        if(s[0] == '0') {
            int i = 1;
            while(s[i] == '0') i++;
            swap(s[0], s[i]);
        }
        return stoll(s);
    }
};