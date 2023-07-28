class Solution {
    public String smallestSubsequence(String s, int k, char letter, int repetition) {
        
        int[] freq = new int[26];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }
        int[] count = new int[26];
        int[] seen = new int[26];
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            freq[c - 'a']--;
            if (seen[c - 'a']++ > 0) {
                continue;
            }
            while (!stack.isEmpty() && c < stack.peek() && freq[stack.peek() - 'a'] > 0) {
                seen[stack.pop() - 'a'] = 0;
            }
            stack.push(c);
        }
        char[] result = new char[k];
        for (int i = k - 1; i >= 0; i--) {
            char c = stack.pop();
            result[i] = c;
            count[c - 'a']++;
        }
        int start = 0, end = k - 1;
        while (count[letter - 'a'] < repetition) {
            char c = result[start];
            if (c == letter) {
                count[c - 'a']--;
                while (result[end] != letter) {
                    end--;
                }
                result[end--] = c;
            }
            start++;
        }
        return new String(result);
    }
}