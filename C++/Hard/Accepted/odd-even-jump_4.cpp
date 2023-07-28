class Solution {
public:
    int oddEvenJumps(vector<int>& arr) {
        
        int n = arr.size();
        vector<int> odd(n);
        vector<int> even(n);
        map<int,int> m;
        odd[n-1] = even[n-1] = 1;
        m[arr[n-1]] = n-1;
        int res = 1;
        for(int i = n-2; i >= 0; i--){
            auto odd_it = m.lower_bound(arr[i]);
            auto even_it = m.upper_bound(arr[i]);
            if(odd_it != m.end()){
                odd[i] = even[odd_it->second];
            }
            if(even_it != m.begin()){
                even[i] = odd[(--even_it)->second];
            }
            if(odd[i]){
                res++;
            }
            m[arr[i]] = i;
        }
        return res;
    }
};