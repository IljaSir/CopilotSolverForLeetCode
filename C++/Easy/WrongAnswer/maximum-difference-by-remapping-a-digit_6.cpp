class Solution {
public:
    int minMaxDifference(int num) {
        
        int min = num;
        int max = num;
        string s = to_string(num);
        for(int i = 0; i < s.length(); i++){
            for(int j = 0; j < 10; j++){
                if(s[i] - '0' == j) continue;
                string tmp = s;
                tmp[i] = j + '0';
                if(tmp[0] != '0'){
                    int n = stoi(tmp);
                    if(n < min) min = n;
                    if(n > max) max = n;
                }
            }
        }
        return max - min;
    }
};