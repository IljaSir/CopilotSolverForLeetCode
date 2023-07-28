class Solution {
public:
    bool reorderedPowerOf2(int n) {
        
        string s = to_string(n);
        sort(s.begin(), s.end());
        long long int nn = stoll(s);
        long long int i=1;
        while(i<=1e9){
            long long int ii = i;
            string ss = to_string(ii);
            sort(ss.begin(), ss.end());
            long long int nnn = stoll(ss);
            if(nnn==nn)
                return true;
            i<<=1;
        }
        return false;
    }
};