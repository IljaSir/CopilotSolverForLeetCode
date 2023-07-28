class Solution {
public:
    string decodeCiphertext(string encodedText, int rows) {
        
        string result;
        int n = encodedText.size();
        int columns = n / rows;
        int index = 0;
        for(int i = 0; i < columns; i++){
            if(i % 2 == 0){
                for(int j = 0; j < rows; j++){
                    result += encodedText[index++];
                }
            }else{
                for(int j = 0; j < rows - 1; j++){
                    result += ' ';
                }
                result += encodedText[index++];
                for(int j = 0; j < rows - 1; j++){
                    result += ' ';
                }
            }
        }
        return result;
    }
};