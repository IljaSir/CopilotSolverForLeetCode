class Solution {
    public int totalStrength(int[] strength) {
        
        int n = strength.length;
        int[] left = new int[n];
        int[] right = new int[n];
        Stack<Integer> stack = new Stack<>();
        for(int i=0; i<n; i++){
            while(!stack.isEmpty() && strength[stack.peek()] > strength[i]){
                right[stack.pop()] = i;
            }
            left[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }
        while(!stack.isEmpty()){
            right[stack.pop()] = n;
        }
        long mod = 1000000007;
        long sum = 0;
        for(int i=0; i<n; i++){
            long leftCount = i - left[i];
            long rightCount = right[i] - i;
            sum += strength[i] * leftCount * rightCount;
            sum %= mod;
        }
        return (int)sum;
    }
}