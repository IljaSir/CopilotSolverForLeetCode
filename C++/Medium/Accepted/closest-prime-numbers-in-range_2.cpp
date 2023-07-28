class Solution {
public:
    vector<int> closestPrimes(int left, int right) {
        
        vector<int> v;
        for(int i=left;i<=right;i++){
            if(isPrime(i)){
                v.push_back(i);
            }
        }
        if(v.size()==0){
            return {-1,-1};
        }
        int min=INT_MAX;
        int a=-1,b=-1;
        for(int i=0;i<v.size()-1;i++){
            if(v[i+1]-v[i]<min){
                min=v[i+1]-v[i];
                a=v[i];
                b=v[i+1];
            }
        }
        return {a,b};
    }
    bool isPrime(int n){
        if(n<=1){
            return false;
        }
        for(int i=2;i*i<=n;i++){
            if(n%i==0){
                return false;
            }
        }
        return true;
    }
};