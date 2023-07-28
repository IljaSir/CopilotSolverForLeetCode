class Solution {
public:
    string digitSum(string s, int k) {
        
        string res;
        while(s.length() > k){
            string t;
            for(int i = 0; i < s.length(); i += k){
                int sum = 0;
                for(int j = i; j < i + k; j++){
                    if(j < s.length()){
                        sum += s[j] - '0';
                    }
                }
                t += to_string(sum);
            }
            s = t;
        }
        int sum = 0;
        for(int i = 0; i < s.length(); i++){
            sum += s[i] - '0';
        }
        return to_string(sum);
    }
    string calculate(string s, int k) {
        int sum = 0;
        for(int i = 0; i < s.length(); i++){
            sum += s[i] - '0';
        }
        return to_string(sum);
    }
    string merge(string s, int k) {
        string res;
        while(s.length() > k){
            string t;
            for(int i = 0; i < s.length(); i += k){
                int sum = 0;
                for(int j = i; j < i + k; j++){
                    if(j < s.length()){
                        sum += s[j] - '0';
                    }
                }
                t += to_string(sum);
            }
            s = t;
        }
        return s;
    }
    string truncate(string s, int k) {
        return s.substr(0, k);
    }
    string truncateAndMerge(string s, int k) {
        string res;
        while(s.length() > k){
            string t;
            for(int i = 0; i < s.length(); i += k){
                int sum = 0;
                for(int j = i; j < i + k; j++){
                    if(j < s.length()){
                        sum += s[j] - '0';
                    }
                }
                t += to_string(sum);
            }
            s = t;
        }
        return s;
    }
};