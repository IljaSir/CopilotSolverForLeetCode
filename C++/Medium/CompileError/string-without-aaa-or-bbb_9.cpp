class Solution {
public:
    string strWithout3a3b(int a, int b) {
        
        string s;
        while(a > 0 || b > 0){
            int n = s.size();
            if(n >= 2 && s[n-1] == s[n-2]){
                if(s[n-1] == 'a'){
                    s.push_back('b');
                    b--;
                }
                else{
                    s.push_back('a');
                    a--;
                }
            }
            else if(a > b){
                s.push_back('a');
                a--;
            }
            else{
                s.push_back('b');
                b--
                    --b;
                }
            }
        }
        return s;
    }
};