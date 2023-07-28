class Solution {
    public int[] threeEqualParts(int[] arr) {
        
        int n = arr.length;
        int count = 0;
        for(int i = 0; i < n; i++){
            if(arr[i] == 1) count++;
        }
        if(count % 3 != 0) return new int[]{-1, -1};
        if(count == 0) return new int[]{0, n-1};
        int k = count / 3;
        int i = 0;
        int j = 0;
        int l = 0;
        int r = 0;
        int c = 0;
        for(int p = 0; p < n; p++){
            if(arr[p] == 1){
                c++;
                if(c == 1) i = p;
                if(c == k + 1) l = p;
                if(c == k * 2 + 1) j = p;
                if(c == k * 3 + 1) r = p;
            }
        }
        while(r < n && arr[i] == arr[l] && arr[l] == arr[j] && arr[j] == arr[r]){
            i++;
            l++;
            j++;
            r++;
        }
        if(r == n) return new int[]{i-1, j};
        return new int[]{-1, -1};
    }
}