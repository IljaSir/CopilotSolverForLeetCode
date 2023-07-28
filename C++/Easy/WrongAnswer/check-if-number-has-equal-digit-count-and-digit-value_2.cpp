class Solution {
public:
    bool digitCount(string num) {
        
        int arr[10]={0};
        for(int i=0;i<num.size();i++)
        {
            arr[num[i]-'0']++;
        }
        for(int i=0;i<num.size();i++)
        {
            if(arr[num[i]-'0']!=num[i]-'0')
            {
                return false;
            }
        }
        return true;
    }
    bool isGood(string num) {
        return digitCount(num);
    }
};