class Solution {
    public int reductionOperations(int[] nums) {
        
        int[] count = new int[50001];
        int max = 0;
        for(int num : nums){
            count[num]++;
            max = Math.max(max, num);
        }
        int ans = 0;
        int sum = 0;
        for(int i = max; i > 0; i--){
            sum += count[i];
            ans += sum;
        }
        return ans;
    }
}