class Solution {
    public int countHighestScoreNodes(int[] parents) {
        
        int n = parents.length;
        int[] children = new int[n];
        for(int i = 0; i < n; i++){
            if(parents[i] != -1){
                children[parents[i]]++;
            }
        }
        int[] scores = new int[n];
        int max = 0;
        for(int i = n - 1; i >= 0; i--){
            if(children[i] == 0){
                scores[i] = 1;
            }else{
                int max1 = 0;
                int max2 = 0;
                for(int j = 0; j < n; j++){
                    if(parents[j] == i){
                        if(scores[j] >= max1){
                            max2 = max1;
                            max1 = scores[j];
                        }else if(scores[j] > max2){
                            max2 = scores[j];
                        }
                    }
                }
                scores[i] = (max1 + 1) * (max2 + 1);
                max = Math.max(max, scores[i]);
            }
        }
        int count = 0;
        for(int i = 0; i < n; i++){
            if(scores[i] == max){
                count++;
            }
        }
        return count;
    }
}