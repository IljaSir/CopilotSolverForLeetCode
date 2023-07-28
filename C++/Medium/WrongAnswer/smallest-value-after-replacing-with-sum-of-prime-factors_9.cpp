class Solution {
public:
    int smallestValue(int n) {
        
        vector<int> primes;
        vector<int> factors; // prime factors
        for(int i=2; i<=n; i++){
            bool isPrime = true;
            for(int j=2; j<i; j++){
                if(i%j == 0){
                    isPrime = false;
                    break;
                }
            }
            if(isPrime){
                primes.push_back(i);
            }
        }
        int sum = 0;
        for(int i=0; i<primes.size(); i++){
            if(n%primes[i] == 0){
                factors.push_back(primes[i]);
                sum += primes[i];
            }
        }
        if(sum == n){
            return sum;
        }
        else{
            return smallestValue(sum);
        }
    }
};