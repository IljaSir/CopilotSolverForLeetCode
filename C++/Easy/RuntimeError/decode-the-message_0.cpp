class Solution {
public:
    string decodeMessage(string key, string message) {
        
        string alphabet = "abcdefghijklmnopqrstuvwxyz";
        string result = "";
        for(int i = 0; i < message.size(); i++){
            if(message[i] == ' '){
                result += ' ';
            } else {
                for(int j = 0; j < key.size(); j++){
                    if(key[j] == message[i]){
                        result += alphabet[j];
                        break;
                    }
                }
            }
        }
        return result;
    }
};