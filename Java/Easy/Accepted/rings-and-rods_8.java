class Solution {
    public int countPoints(String rings) {
        
        int count = 0;
        int[] arr = new int[10];
        for(int i = 0; i < rings.length(); i += 2) {
            if(rings.charAt(i) == 'R') {
                arr[rings.charAt(i+1) - '0'] |= 1;
            }
            if(rings.charAt(i) == 'G') {
                arr[rings.charAt(i+1) - '0'] |= 2;
            }
            if(rings.charAt(i) == 'B') {
                arr[rings.charAt(i+1) - '0'] |= 4;
            }
        }
        for(int i = 0; i < 10; i++) {
            if(arr[i] == 7) {
                count++;
            }
        }
        return count;
    }
}