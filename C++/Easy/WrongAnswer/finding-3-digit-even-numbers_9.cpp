class Solution {
public:
    vector<int> findEvenNumbers(vector<int>& digits) {
        
        vector<int> evenNumbers;
        vector<int> temp;
        int n = digits.size();
        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < n; j++)
            {
                for(int k = 0; k < n; k++)
                {
                    if(i != j && i != k && j != k)
                    {
                        temp.push_back(digits[i]);
                        temp.push_back(digits[j]);
                        temp.push_back(digits[k]);
                        int num = temp[0] * 100 + temp[1] * 10 + temp[2];
                        if(num % 2 == 0)
                        {
                            evenNumbers.push_back(num);
                        }
                        temp.clear();
                    }
                }
            }
        }
        sort(evenNumbers.begin(), evenNumbers.end());
        evenNumbers.erase(unique(evenNumbers.begin(), evenNumbers.end()), evenNumbers.end());
        return evenNumbers;
    }
};