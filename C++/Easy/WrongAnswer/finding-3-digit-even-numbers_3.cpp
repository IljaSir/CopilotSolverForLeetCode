class Solution {
public:
    vector<int> findEvenNumbers(vector<int>& digits) {
        
        vector<int> evenNumbers;
        for(int i = 0; i < digits.size(); i++){
            for(int j = 0; j < digits.size(); j++){
                for(int k = 0; k < digits.size(); k++){
                    if(i != j && j != k && i != k){
                        int num = digits[i] * 100 + digits[j] * 10 + digits[k];
                        if(num % 2 == 0){
                            evenNumbers.push_back(num);
                        }
                    }
                }
            }
        }
        sort(evenNumbers.begin(), evenNumbers.end());
        evenNumbers.erase(unique(evenNumbers.begin(), evenNumbers.end()), evenNumbers.end());
        return evenNumbers;
    }
};