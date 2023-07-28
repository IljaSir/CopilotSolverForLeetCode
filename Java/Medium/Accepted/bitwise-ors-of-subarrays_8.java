class Solution {
    public int subarrayBitwiseORs(int[] arr) {
        
        Set<Integer> set = new HashSet<>();
        Set<Integer> res = new HashSet<>();
        for(int i = 0; i < arr.length; i++){
            Set<Integer> temp = new HashSet<>();
            temp.add(arr[i]);
            for(int s : set){
                temp.add(s | arr[i]);
            }
            set = temp;
            res.addAll(set);
        }
        return res.size();
    }
}