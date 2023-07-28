class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        
        int[] arr=new int[60];
        for(int i=0;i<time.length;i++)
        {
            arr[time[i]%60]++;
        }
        int count=0;
        for(int i=0;i<60;i++)
        {
            if(i==0 || i==30)
            {
                if(arr[i]>=2)
                {
                    count+=(arr[i]*(arr[i]-1))/2;
                }
            }
            else if(i<30)
            {
                if(arr[i]>0 && arr[60-i]>0)
                {
                    count+=arr[i]*arr[60-i];
                }
            }
        }
        return count;
    }
}