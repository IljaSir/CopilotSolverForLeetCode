class Solution {
    public List<Integer> twoOutOfThree(int[] nums1, int[] nums2, int[] nums3) {
        
        List<Integer> ans = new ArrayList<Integer>();
        int[] count = new int[101];
        for(int n: nums1) {
            count[n]++;
        }
        for(int n: nums2) {
            count[n]++;
        }
        for(int n: nums3) {
            count[n]++;
        }
        for(int i=1; i<=100; i++) {
            if(count[i] >= 2) {
                ans.add(i);
            }
        }
        return ans;
    }
}