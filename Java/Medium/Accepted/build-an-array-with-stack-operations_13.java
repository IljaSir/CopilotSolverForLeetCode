class Solution {
    public List<String> buildArray(int[] target, int n) {
        
        List<String> list = new ArrayList<String>();
        for(int i=1;i<=n;i++){
            if(i>target[target.length-1]){
                break;
            }
            list.add("Push");
            if(Arrays.binarySearch(target,i)>=0){
                continue;
            }else{
                list.add("Pop");
            }
        }
        return list;
    }
}