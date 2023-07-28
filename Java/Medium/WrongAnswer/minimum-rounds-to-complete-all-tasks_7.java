class Solution {
    public int minimumRounds(int[] tasks) {
        
        int[] freq = new int[1000001];
        for(int task: tasks){
            freq[task]++;
        }
        int res = 0;
        for(int i = 1; i < freq.length; i++){
            if(freq[i] == 0) continue;
            if(freq[i] % 2 == 1){
                freq[i]--;
                freq[i+1]++;
            }
            res += freq[i] / 2;
        }
        return res;
    }
}