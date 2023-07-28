class Solution {
public:
    string strWithout3a3b(int a, int b) {
        
        string s;
        while (a || b) {
            bool write_a = false;
            int len = s.size();
            if (len >= 2 && s[len-1] == s[len-2]) {
                if (s[len-1] == 'b')
                    write_a = true;
            } else {
                if (a >= b)
                    write_a = true;
            }
            if (write_a) {
                --a;
                s.push_back('a');
            } else {
                --b;
                s.push_back('b');
            }
        }
        return s;
    }
};