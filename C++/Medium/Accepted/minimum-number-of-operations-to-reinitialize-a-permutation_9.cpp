class Solution {
public:
    int reinitializePermutation(int n) {
        
        int perm[n];
        int arr[n];
        for(int i=0;i<n;i++){
            perm[i] = i;
        }
        int count = 0;
        while(true){
            for(int i=0;i<n;i++){
                if(i%2==0){
                    arr[i] = perm[i/2];
                }
                else{
                    arr[i] = perm[n/2 + (i-1)/2];
                }
            }
            count++;
            for(int i=0;i<n;i++){
                perm[i] = arr[i];
            }
            bool check = true;
            for(int i=0;i<n;i++){
                if(perm[i]!=i){
                    check = false;
                    break;
                }
            }
            if(check){
                break;
            }
        }
        return count;
    }
};