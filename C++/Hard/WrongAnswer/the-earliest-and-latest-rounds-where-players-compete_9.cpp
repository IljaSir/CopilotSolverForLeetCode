class Solution {
public:
    vector<int> earliestAndLatest(int n, int firstPlayer, int secondPlayer) {
        
        vector<int> ans;
        int round = 0;
        int min = 0;
        int max = 0;
        int i = 0;
        while(n > 1){
            n = n / 2;
            round++;
        }
        min = round;
        max = round;
        if(firstPlayer > secondPlayer){
            swap(firstPlayer, secondPlayer);
        }
        while(round > 1){
            round--;
            if(firstPlayer % 2 == 1 && secondPlayer % 2 == 0){
                if(secondPlayer - firstPlayer == 1){
                    max = round;
                    break;
                }
            }
            if(firstPlayer % 2 == 0 && secondPlayer % 2 == 1){
                if(secondPlayer - firstPlayer == 1){
                    max = round;
                    break;
                }
            }
            if(firstPlayer % 2 == 1 && secondPlayer % 2 == 1){
                if(secondPlayer - firstPlayer == 2){
                    max = round;
                    break;
                }
            }
            if(firstPlayer % 2 == 0 && secondPlayer % 2 == 0){
                if(secondPlayer - firstPlayer == 2){
                    max = round;
                    break;
                }
            }
            firstPlayer = (firstPlayer + 1) / 2;
            secondPlayer = (secondPlayer + 1) / 2;
        }
        ans.push_back(min);
        ans.push_back(max);
        return ans;
    }
};