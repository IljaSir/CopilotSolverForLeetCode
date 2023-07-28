class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        for(int i=0;i<nums1.length;i++){
            boolean flag = false;
            for(int j=0;j<nums2.length;j++){
                if(nums1[i]==nums2[j]){
                    flag = true;
                    break;
                }
            }
            if(!flag){
                list1.add(nums1[i]);
            }
        }
        for(int i=0;i<nums2.length;i++){
            boolean flag = false;
            for(int j=0;j<nums1.length;j++){
                if(nums2[i]==nums1[j]){
                    flag = true;
                    break;
                }
            }
            if(!flag){
                list2.add(nums2[i]);
            }
        }
        ans.add(list1);
        ans.add(list2);
        return ans;
    }
}