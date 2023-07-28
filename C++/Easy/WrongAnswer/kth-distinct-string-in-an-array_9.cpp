class Solution {
public:
    string kthDistinct(vector<string>& arr, int k) {
        
        set<string> s;
        for(string str: arr)
            s.insert(str);
        if(s.size() < k)
            return "";
        int i = 0;
        for(auto it = s.begin(); it != s.end(); it++){
            if(i == k-1)
                return *it;
            i++;
        }
        return "";
    }
};