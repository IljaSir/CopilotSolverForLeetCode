class Solution {
    public String robotWithString(String s) {
        
        int n = s.length();
        char[] arr = s.toCharArray();
        char[] ans = new char[n];
        int left = 0, right = n-1;
        int index = 0;
        while(left <= right) {
            boolean leftIsSmaller = false;
            for(int i=0; left+i <= right; i++) {
                if(arr[left+i] < arr[right-i]) {
                    leftIsSmaller = true;
                    break;
                } else if(arr[left+i] > arr[right-i]) {
                    break;
                }
            }
            if(leftIsSmaller) {
                ans[index++] = arr[left++];
            } else {
                ans[index++] = arr[right--];
            }
        }
        return new String(ans);
    }
}