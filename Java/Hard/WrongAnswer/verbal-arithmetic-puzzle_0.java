class Solution {
    public boolean isSolvable(String[] words, String result) {
        
        int n = words.length;
        int m = result.length();
        int[] cnt = new int[26];
        for (String word : words) {
            for (char c : word.toCharArray()) {
                cnt[c - 'A']++;
            }
        }
        for (char c : result.toCharArray()) {
            cnt[c - 'A']++;
        }
        int[] digits = new int[26];
        for (int i = 0; i < 26; i++) {
            if (cnt[i] > 0) {
                digits[i] = -1;
            }
        }
        return dfs(words, result, digits, 0, 0);
    }
    private boolean dfs(String[] words, String result, int[] digits, int pos, int carry) {
        if (pos == result.length()) {
            return carry == 0;
        }
        int idx = result.charAt(pos) - 'A';
        if (digits[idx] != -1) {
            int sum = carry;
            for (String word : words) {
                if (word.length() > pos) {
                    sum += digits[word.charAt(word.length() - pos - 1) - 'A'];
                }
            }
            return sum % 10 == digits[idx] && dfs(words, result, digits, pos + 1, sum / 10);
        }
        for (int i = 0; i <= 9; i++) {
            if (i == 0 && pos == result.length() - 1) {
                continue;
            }
            boolean ok = true;
            for (int j = 0; j < 26; j++) {
                if (digits[j] == i) {
                    ok = false;
                    break;
                }
            }
            if (ok) {
                digits[idx] = i;
                int sum = carry;
                for (String word : words) {
                    if (word.length() > pos) {
                        sum += digits[word.charAt(word.length() - pos - 1) - 'A'];
                    }
                }
                if (sum % 10 == i && dfs(words, result, digits, pos + 1, sum / 10)) {
                    return true;
                }
                digits[idx] = -1;
            }
        }
        return false;
    }
}