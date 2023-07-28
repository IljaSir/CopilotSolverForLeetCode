class Solution {
public:
    int partitionString(string s) {
        
        int max_index[26];
        for(int i=0; i<26; i++)
            max_index[i] = -1;
        for(int i=0; i<s.length(); i++)
            max_index[s[i]-'a'] = i;
        int start = 0, end = 0, count = 0;
        while(end < s.length()){
            end = max_index[s[start]-'a'];
            int i = start;
            while(i < end){
                if(max_index[s[i]-'a'] > end)
                    end = max_index[s[i]-'a'];
                i++;
            }
            start = end+1;
            count++;
        }
        return count;
    }
};