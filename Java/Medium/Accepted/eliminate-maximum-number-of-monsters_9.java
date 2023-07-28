class Solution {
    public int eliminateMaximum(int[] dist, int[] speed) {
        
        int n=dist.length;
        int[] time=new int[n];
        for(int i=0;i<n;i++){
            time[i]=dist[i]/speed[i];
            if(dist[i]%speed[i]!=0)
                time[i]++;
        }
        Arrays.sort(time);
        int cnt=0;
        for(int i=0;i<n;i++){
            if(time[i]<=i)
                break;
            cnt++;
        }
        return cnt;
    }
}