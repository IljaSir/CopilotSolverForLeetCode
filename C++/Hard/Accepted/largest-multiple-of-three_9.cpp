class Solution {
public:
    string largestMultipleOfThree(vector<int>& digits) {
        
        int sum = 0;
        string ans = "";
        vector<int> count(10,0);
        for(auto x:digits){
            sum += x;
            count[x]++;
        }
        if(sum%3==1){
            if(count[1]>0) count[1]--;
            else if(count[4]>0) count[4]--;
            else if(count[7]>0) count[7]--;
            else if(count[2]>1) count[2]-=2;
            else if(count[5]>1) count[5]-=2;
            else if(count[8]>1) count[8]-=2;
            else if(count[2]>0 && count[5]>0) count[2]--,count[5]--;
            else if(count[2]>0 && count[8]>0) count[2]--,count[8]--;
            else if(count[5]>0 && count[8]>0) count[5]--,count[8]--;
            else return "";
        }
        if(sum%3==2){
            if(count[2]>0) count[2]--;
            else if(count[5]>0) count[5]--;
            else if(count[8]>0) count[8]--;
            else if(count[1]>1) count[1]-=2;
            else if(count[4]>1) count[4]-=2;
            else if(count[7]>1) count[7]-=2;
            else if(count[1]>0 && count[4]>0) count[1]--,count[4]--;
            else if(count[1]>0 && count[7]>0) count[1]--,count[7]--;
            else if(count[4]>0 && count[7]>0) count[4]--,count[7]--;
            else return "";
        }
        for(int i=9;i>=0;i--){
            while(count[i]--){
                ans += to_string(i);
            }
        }
        if(ans.size()>0 && ans[0]=='0') return "0";
        return ans;
    }
};