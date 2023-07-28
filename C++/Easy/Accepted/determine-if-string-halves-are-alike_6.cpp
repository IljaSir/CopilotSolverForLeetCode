class Solution {
public:
    bool halvesAreAlike(string s) {
        
        int n = s.size();
        string a = s.substr(0, n/2);
        string b = s.substr(n/2, n/2);
        int countA = 0;
        int countB = 0;
        for(int i = 0; i < n/2; i++){
            if(a[i] == 'a' || a[i] == 'e' || a[i] == 'i' || a[i] == 'o' || a[i] == 'u' || a[i] == 'A' || a[i] == 'E' || a[i] == 'I' || a[i] == 'O' || a[i] == 'U')
                countA++;
            if(b[i] == 'a' || b[i] == 'e' || b[i] == 'i' || b[i] == 'o' || b[i] == 'u' || b[i] == 'A' || b[i] == 'E' || b[i] == 'I' || b[i] == 'O' || b[i] == 'U')
                countB++;
        }
        return countA == countB;
    }
};