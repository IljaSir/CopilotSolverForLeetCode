class Solution {
public:
    string largestMerge(string word1, string word2) {
        
        string merge;
        int i = 0, j = 0, n = word1.size(), m = word2.size();
        while(i < n || j < m){
            if(i == n){
                merge += word2[j];
                j++;
            }
            else if(j == m){
                merge += word1[i];
                i++;
            }
            else if(word1[i] < word2[j]){
                merge += word2[j];
                j++;
            }
            else if(word1[i] > word2[j]){
                merge += word1[i];
                i++;
            }
            else{
                int k = 1;
                while(i + k < n && j + k < m && word1[i+k] == word2[j+k]){
                    k++;
                }
                if(i + k == n){
                    merge += word2[j];
                    j++;
                }
                else if(j + k == m){
                    merge += word1[i];
                    i++;
                }
                else if(word1[i+k] < word2[j+k]){
                    merge += word2[j];
                    j++;
                }
                else{
                    merge += word1[i];
                    i++;
                }
            }
        }
        return merge;
    }
};