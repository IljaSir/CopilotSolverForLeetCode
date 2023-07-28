class Solution {
public:
    int divisorSubstrings(int num, int k) {
        
        int count = 0;
        string num_str = to_string(num);
        for(int i = 0; i + k <= num_str.size(); ++i){
            string sub_str = num_str.substr(i, k);
            if(sub_str[0] == '0' && k > 1)
                continue;
            int sub_num = stoi(sub_str);
            if(num % sub_num == 0)
                count++;
        }
        return count;
    }
};