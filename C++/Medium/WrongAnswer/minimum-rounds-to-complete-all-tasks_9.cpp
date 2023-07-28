class Solution {
public:
    int minimumRounds(vector<int>& tasks) {
        
        int n=tasks.size();
        int res=0;
        int cnt[3]={0};
        for(int i=0;i<n;i++){
            int x=tasks[i];
            if(x%2==0){
                int y=x/2;
                if(cnt[0]>=y){
                    cnt[0]-=y;
                }
                else{
                    y-=cnt[0];
                    cnt[0]=0;
                    cnt[1]+=y/3;
                    if(y%3!=0){
                        cnt[2]=3-y%3;
                    }
                }
            }
            else{
                int y=x/2+1;
                if(cnt[0]>=y){
                    cnt[0]-=y;
                }
                else{
                    y-=cnt[0];
                    cnt[0]=0;
                    cnt[1]+=y/3;
                    if(y%3!=0){
                        cnt[2]=3-y%3;
                    }
                }
            }
            cnt[0]++;
            res+=cnt[2]/3;
            cnt[1]+=cnt[2]/3;
            cnt[2]%=3;
            res+=cnt[1]/3;
            cnt[0]+=cnt[1]/3;
            cnt[1]%=3;
        }
        res+=cnt[2]/3;
        cnt[1]+=cnt[2]/3;
        cnt[2]%=3;
        res+=cnt[1]/3;
        cnt[0]+=cnt[1]/3;
        cnt[1]%=3;
        if(cnt[0]>0||cnt[1]>0||cnt[2]>0){
            res++;
        }
        return res;
    }
};