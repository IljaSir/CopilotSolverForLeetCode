class Solution {
public:
    bool areSentencesSimilar(string sentence1, string sentence2) {
        
        int i=0, j=0, n=sentence1.size(), m=sentence2.size();
        while(i<n && j<m){
            if(sentence1[i]==sentence2[j]) i++, j++;
            else break;
        }
        if(i==n || j==m) return true;
        i=n-1, j=m-1;
        while(i>=0 && j>=0){
            if(sentence1[i]==sentence2[j]) i--, j--;
            else break;
        }
        return i<0 || j<0;
    }
};