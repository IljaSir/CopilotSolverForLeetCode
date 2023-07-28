class Solution {
public:
    string generateTheString(int n) {
        
        string s;
        for(int i = 0; i < n-1; i++)
        {
            s += 'a';
        }
        s += (n%2 == 0) ? 'b' : 'a';
        return s;
    }
};