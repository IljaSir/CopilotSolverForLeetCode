class Solution {
    public int[] threeEqualParts(int[] arr) {
        
        int[] res = new int[2];
        int n = arr.length;
        int count = 0;
        for(int i=0;i<n;i++){
            if(arr[i]==1) count++;
        }
        if(count==0){
            res[0] = 0;
            res[1] = n-1;
            return res;
        }
        if(count%3!=0) return new int[]{-1,-1};
        int k = count/3;
        int i = 0;
        int j = 0;
        int l = 0;
        int m = 0;
        int p = 0;
        while(p<k){
            if(arr[i]==1) p++;
            i++;
        }
        while(i<n && arr[i]==0) i++;
        j = i;
        p = 0;
        while(p<k){
            if(arr[j]==1) p++;
            j++;
        }
        while(j<n && arr[j]==0) j++;
        m = j;
        p = 0;
        while(p<k){
            if(arr[m]==1) p++;
            m++;
        }
        while(m<n && arr[m]==0) m++;
        if(m!=n) return new int[]{-1,-1};
        while(arr[i]==arr[j] && arr[j]==arr[m] && m<n){
            i++;
            j++;
            m++;
        }
        if(m==n) return new int[]{i-1,j};
        return new int[]{-1,-1};
    }
}