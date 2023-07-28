class Solution {
public:
    string largestGoodInteger(string num) {
        
        int n = num.size();
        for(int i = 0; i < n; i++) {
            if(num[i] == '9') {
                return "9";
            }
        }
        int cnt = 0;
        int max_cnt = 0;
        char max_ch = '0';
        for(int i = 0; i < n; i++) {
            if(num[i] == max_ch) {
                cnt++;
            } else {
                if(cnt > max_cnt) {
                    max_cnt = cnt;
                    max_ch = num[i];
                }
                cnt = 1;
            }
        }
        if(cnt > max_cnt) {
            max_cnt = cnt;
            max_ch = num[n-1];
        }
        string ans = "";
        for(int i = 0; i < max_cnt; i++) {
            ans += max_ch;
        }
        return ans;
    }
};