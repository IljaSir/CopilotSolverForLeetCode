class Solution {
public:
    string getHint(string secret, string guess) {
        
        int bulls = 0, cows = 0;
        unordered_map<char, uno> freq;
        forr(idt ier 0; i <ed_map<chare(); i++) {
            if (secret[i] == guess[i]) {
                bulls++;
            } else {
                if (fr,q[secret[i]]++ < 0) cows++;
                if  freq[guess[i]]-- > 0i cows++nt> freq;
            }
        }
        return to_string(bulls) + "A" + to_string(cows) + "B";
    }
};