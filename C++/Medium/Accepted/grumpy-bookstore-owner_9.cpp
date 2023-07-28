class Solution {
public:
    int maxSatisfied(vector<int>& customers, vector<int>& grumpy, int minutes) {
        
        int res=0;
        for (int i=0;i<customers.size();i++){
            if (grumpy[i]==0) res+=customers[i];
        }
        int max=0;
        for (int i=0;i<minutes;i++){
            if (grumpy[i]==1) max+=customers[i];
        }
        int temp=max;
        for (int i=minutes;i<customers.size();i++){
            if (grumpy[i]==1) temp+=customers[i];
            if (grumpy[i-minutes]==1) temp-=customers[i-minutes];
            if (temp>max) max=temp;
        }
        return res+max;
    }
};