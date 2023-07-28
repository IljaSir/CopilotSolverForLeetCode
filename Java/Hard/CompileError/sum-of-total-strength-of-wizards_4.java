class Solution {
    public int totalStrength(int[] strength) {
        
        int sum = 0, mod = 1000000007;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < strength.length; i++) {
            int cnt = 1;
            while (!stack.isEmpty() && stack.peek() >= strength[i]) {
                if (stack.peek() == strength[i]) cnt++;
                sum = (sum + (long) stack.peek() * cnt) % mod;
                stack.pop();
            }
            stack.push(strength[i]);
            sum = (sum + (long) strength[i] * cnt) % mod;
        }
        return sum;
    }
}