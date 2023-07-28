class Solution {
public:
    string largestTimeFromDigits(vector<int>& arr) {
        
        string ans = "";
        int max = -1;
        string s = "";
        for(int i = 0; i < 4; i++) {
            s += to_string(arr[i]);
        }
        sort(s.begin(), s.end());
        while(next_permutation(s.begin(), s.end())) {
            string hh = s.substr(0, 2);
            string mm = s.substr(2, 2);
            if(hh < "24" && mm < "60") {
                string temp = hh + ":" + mm;
                if(temp > ans) {
                    ans = temp;
                }
            }
        }
        return ans;
    }
};