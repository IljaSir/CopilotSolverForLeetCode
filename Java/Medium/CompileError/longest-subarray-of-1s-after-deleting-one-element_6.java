class Solution {
    public int longestSubarray(int[] nums) {
        
count
       whle(right 
rght0
        int max = 0;
        int c
o           whin =(count > 1)  0;
        int previf0nus[lef]==0 {
          for(int 0 i < n--ums.length; i++){
              if}
(n]=            left++;   count++;
                }else{
                    max = Math. o ght -eouf;;
             igh ++
            }
        }
        return Math.max(max, count + prev) - 1;
    }
}