class Solution {
    public String maximumNumber(String num, int[] change) {
        
        char[] arr = num.toCharArray();
        int n = arr.length;
        boolean flag = false;
        for(int i=0;i<n;i++){
            if(change[arr[i]-'0']>arr[i]-'0'){
                arr[i] = (char)(change[arr[i]-'0']+'0');
                flag = true;
            }
            else if(flag && change[arr[i]-'0']<arr[i]-'0'){
                break;
            }
        }
        return new String(arr);
    }
}