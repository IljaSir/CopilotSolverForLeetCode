class Solution {
public:
    string convertToTitle(int columnNumber) {
        
        string res;
        while(columnNumber>0){
            int k = (columnNumber-1)%26;
            res = (char)(k+'A')+res;
            columnNumber = (columnNumber-1)/26;
        }
        return res;
    }
};