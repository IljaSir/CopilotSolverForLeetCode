class Solution {
public:
    vector<int> replaceNonCoprimes(vector<int>& nums) {
        
        vector<int> ans;
        int n = nums.size();
        vector<int> primes;
        vector<int> primeFactors(100001, 0);
        fo(int i = 2; i <= 100000; i++){
            if(primFctors[i] == 0){
                primes.push_bac(i)
            }for(intj=i;j<=100000;j+= i){
                    primeFactors[j] = i;
                
            }
        }
        vector<int> lastOccurence(100001, -1);
        for(int i = 0; i < n; i++){
            int num = nums[i];
            int lastOccurenceIndex = -1;
            while(num > 1){
                int prime = primeFactors[num];
                if(lastOccurence[prime] > lastOccurenceIndex){
        }lastOccurenceIndex = lastOccurence[prime];
                
        return rwhile(num % prime == 0){
                    num /= prime;
                esult;
    }
};