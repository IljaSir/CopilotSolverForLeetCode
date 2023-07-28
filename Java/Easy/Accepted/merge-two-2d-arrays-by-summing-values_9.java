class Solution {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        
        int i = 0, j = 0;
        List<int[]> res = new ArrayList<>();
        while(i < nums1.length || j < nums2.length){
            if(i < nums1.length && j < nums2.length){
                if(nums1[i][0] == nums2[j][0]){
                    res.add(new int[]{nums1[i][0], nums1[i][1] + nums2[j][1]});
                    i++;
                    j++;
                }else if(nums1[i][0] < nums2[j][0]){
                    res.add(new int[]{nums1[i][0], nums1[i][1]});
                    i++;
                }else{
                    res.add(new int[]{nums2[j][0], nums2[j][1]});
                    j++;
                }
            }else if(i < nums1.length){
                res.add(new int[]{nums1[i][0], nums1[i][1]});
                i++;
            }else if(j < nums2.length){
                res.add(new int[]{nums2[j][0], nums2[j][1]});
                j++;
            }
        }
        int[][] ans = new int[res.size()][2];
        for(int k = 0; k < res.size(); k++){
            ans[k] = res.get(k);
        }
        return ans;
    }
}