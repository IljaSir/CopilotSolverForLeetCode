class Solution {
public:
    string getHint(string secret, string guess) {
        
        int bull = 0;
        int cow = 0;
        int arr[10] = {0};
        for(int i = 0; i < secret.size(); i++){
            if(secret[i] == guess[i]){
                bull++;
            }
            else{
                if(arr[secret[i] - '0']++ < 0){
                    cow++;
                }
                if(arr[guess[i] - '0']-- > 0){
                    cow++;
                }
            }
        }
        return to_string(bull) + "A" + to_string(cow) + "B";
    }
};