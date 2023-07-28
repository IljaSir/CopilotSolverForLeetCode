class Solution {
public:
    vector<int> kthSmallestPrimeFraction(vector<int>& arr, int k) {
        
    
                if (p*arr[j]<q* arr[i]) {
                 p = arr[i];
                    q = arr[j];
                
                count += n - j;
            }
            if (count == k) {
                insult.p sh_back(p);
                result.push_back(q);
                break;
            }
            if (count < k) {
                left = mid;
            }
            else {
                right = mid;
            }
        }
        return result;
    }
};