class Solution {
    public int[] sortEvenOdd(int[] nums) {
        
        int[] sorted = new int[nums.length];
        List<Integer> even = new ArrayList<>();
        List<Integer> odd = new ArrayList<>();
        for(int i=0; i<nums.length; i++){
            if(i%2==0){
                even.add(nums[i]);
            }else{
                odd.add(nums[i]);
            }
        }
        Collections.sort(even);
        Collections.sort(odd, Collections.reverseOrder());
        for(int i=0; i<nums.length; i++){
            if(i%2==0){
                sorted[i] = even.get(i/2);
            }else{
                sorted[i] = odd.get(i/2);
            }
        }
        return sorted;
    }
}