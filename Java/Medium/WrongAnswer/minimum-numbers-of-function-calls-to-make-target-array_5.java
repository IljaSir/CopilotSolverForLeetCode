class Solution {
    public int minOperations(int[] nums) {
        
        int max = 0;
        int count = 0;
        for(int n: nums){
            int c = 0;
            while(n > 0){
                if(n % 2 == 1){
                    count++;
                }
                n /= 2;
                c++;
            }
            max = Math.max(max, c);
        }
        return count + max - 1;
    }
}