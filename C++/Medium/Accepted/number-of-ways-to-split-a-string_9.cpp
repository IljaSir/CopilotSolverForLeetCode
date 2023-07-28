class Solution {
public:
    int numWays(string s) {
        
        int oneCount = 0;
        for(auto c: s){
            if(c == '1')
                oneCount++;
        }
        if(oneCount % 3 != 0)
            return 0;
        if(oneCount == 0){
            return (long long)(s.size()-1)*(s.size()-2)/2 % 1000000007;
        }
        int oneCountPerPart = oneCount / 3;
        int oneCountPerPartIndex = 0;
        long long part1 = 0, part2 = 0;
        for(int i = 0; i < s.size(); i++){
            if(s[i] == '1'){
                oneCountPerPartIndex++;
            }
            if(oneCountPerPartIndex == oneCountPerPart){
                part1++;
            }
            if(oneCountPerPartIndex == oneCountPerPart * 2){
                part2++;
            }
        }
        return part1 * part2 % 1000000007;
    }
};