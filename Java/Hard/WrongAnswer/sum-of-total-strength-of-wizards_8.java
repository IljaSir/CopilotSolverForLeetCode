class Solution {
    public int totalStrength(int[] strength) {
        
        int mod = 1000000007;
        long ans = 0;
        int len = strength.length;
        int[] minLeft = new int[len];
        int[] minRight = new int[len];
        int[] sumLeft = new int[len];
        int[] sumRight = new int[len];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < len; i++) {
            int sum = 0;
            while (!stack.isEmpty() && strength[stack.peek()] >= strength[i]) {
                sum += strength[stack.pop()];
            }
            minLeft[i] = stack.isEmpty() ? strength[i] : Math.min(strength[i], strength[stack.peek()]);
            sumLeft[i] = sum + strength[i];
            stack.push(i);
        }
        stack.clear();
        for (int i = len - 1; i >= 0; i--) {
            int sum = 0;
            while (!stack.isEmpty() && strength[stack.peek()] > strength[i]) {
                sum += strength[stack.pop()];
            }
            minRight[i] = stack.isEmpty() ? strength[i] : Math.min(strength[i], strength[stack.peek()]);
            sumRight[i] = sum + strength[i];
            stack.push(i);
        }
        for (int i = 0; i < len; i++) {
            ans = (ans + (long) minLeft[i] * sumRight[i] + (long) minRight[i] * sumLeft[i] - (long) strength[i] * strength[i]) % mod;
        }
        return (int) ans;
    }
}