class Solution {
public:
    string removeKdigits(string num, int k) {
        
        if (k == num.size()) return "0";
        for (int i = 0; i < k; i++) {
            int j = 0;
            while (j < num.size()-1 && num[j] <= num[j+1]) j++;
            num.erase(num.begin()+j);
        }
        int i = 0;
        while (i < num.size()-1 && num[i] == '0') i++;
        return num.substr(i);
    }
};