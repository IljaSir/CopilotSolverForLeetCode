class Solution {
    public int sumSubarrayMins(int[] arr) {
        
        int n = arr.length;
        int[] left = new int[n];
        int[] right = new int[n];
        Stack<Integer> s1 = new Stack<Integer>();
        Stack<Integer> s2 = new Stack<Integer>();
        for(int i=0;i<n;i++){
            int count = 1;
            while(!s1.isEmpty() && arr[s1.peek()]>arr[i]){
                count+=left[s1.pop()];
            }
            s1.push(i);
            left[i] = count;
        }
        for(int i=n-1;i>=0;i--){
            int count = 1;
            while(!s2.isEmpty() && arr[s2.peek()]>=arr[i]){
                count+=right[s2.pop()];
            }
            s2.push(i);
            right[i] = count;
        }
        int sum = 0;
        int mod = 1000000007;
        for(int i=0;i<n;i++){
            sum = (sum + (arr[i]*left[i]*right[i])%mod)%mod;
        }
        return sum;
    }
}