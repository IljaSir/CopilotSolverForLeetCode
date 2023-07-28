class Solution {
public:
    int minDeletions(string s) {
        
        unordered_map<char,int> m;
        for(auto c:s) m[c]++;
        vector<int> count(s.length()+1,0);
        for(auto it:m){
            count[it.second]++;
        }
        int ans = 0;
        for(int i = s.length(); i > 0; i--){
            if(count[i] > 1){
                int remain = count[i] - 1;
                ans += remain;
                for(int j = i-1; j >= 0; j--){
                    if(count[j] == 0){
                        count[j] = remain;
                        break;
                    }
                    else{
                        remain += count[j];
                        count[j] = 0;
                    }
                }
            }
        }
        return ans;
    }
};