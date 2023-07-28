class Solution {
public:
    string largestMerge(string word1, string word2) {
        
        int i = 0, j = 0;
        string ans = "";
        while(i<word1.size() || j<word2.size()){
            if(i==word1.size()){
                ans += word2.substr(j);
                break;
            }
            if(j==word2.size()){
                ans += word1.substr(i);
                break;
            }
            if(word1[i] > word2[j]){
                ans += word1[i];
                i++;
            }else if(word1[i] < word2[j]){
                ans += word2[j];
                j++;
            }else{
                int ii = i, jj = j;
                while(ii<word1.size() && jj<word2.size() && word1[ii]==word2[jj]){
                    ii++;
                    jj++;
                }
                if(ii==word1.size()){
                    ans += word2.substr(j);
                    break;
                }
                if(jj==word2.size()){
                    ans += word1.substr(i);
                    break;
                }
                if(word1[ii] > word2[jj]){
                    ans += word1[i];
                    i++;
                }else{
                    ans += word2[j];
                    j++;
                }
            }
        }
        return ans;
    }
};