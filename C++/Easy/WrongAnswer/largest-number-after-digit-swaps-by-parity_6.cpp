class Solution {
public:
    int largestInteger(int num) {
        
        vector<int> even;
        vector<int> odd;
        while(num){
            int r = num%10;
            if(r%2==0){
                even.push_back(r);
            }else{
                odd.push_back(r);
            }
            num/=10;
        }
        sort(even.begin(), even.end());
        sort(odd.begin(), odd.end());
        int i=0, j=0;
        int ans = 0;
        while(i<even.size() || j<odd.size()){
            if(i<even.size()){
                ans = ans*10 + even[i++];
            }
            if(j<odd.size()){
                ans = ans*10 + odd[j++];
            }
        }
        return ans;
    }
};