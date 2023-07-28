class Solution {
    public int longestNiceSubarray(int[] nums) {
        
        int n = nums.length;
        int ans = 0;
        for(int i=0;i<n;i++){
            int[] arr = new int[26];
            for(int j=i;j<n;j++){
                char c = (char)(nums[j] - 1 + 'a');
                arr[c-'a']++;
                if(arr[c-'a'] == 1){
                    if(c - 'a' < 13){
                        arr[c-'a'+13]++;
                    }else{
                        arr[c-'a'-13]++;
                    }
                }
                boolean flag = true;
                for(int k=0;k<26;k++){
                    if(arr[k] != 0 && arr[k] != 2){
                        flag = false;
                        break;
                    }
                }
                if(flag){
                    ans = Math.max(ans, j - i + 1);
                }
            }
        }
        return ans;
    }
}