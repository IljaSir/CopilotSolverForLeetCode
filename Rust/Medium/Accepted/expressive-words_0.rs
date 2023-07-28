impl Solution {
    pub fn expressive_words(s: String, words: Vec<String>) -> i32 {
        
        let mut ans = 0;
        for word in words {
            if Self::is_stretchy(&s, &word) {
                ans += 1;
            }
        }
        ans
    }
    fn is_stretchy(s: &str, word: &str) -> bool {
        let (mut i, mut j) = (0, 0);
        let (mut s_len, mut word_len) = (s.len(), word.len());
        while i < s_len && j < word_len {
            if s.chars().nth(i) != word.chars().nth(j) {
                return false;
            }
            let (mut cnt1, mut cnt2) = (0, 0);
            while i < s_len && s.chars().nth(i) == s.chars().nth(i + 1) {
                i += 1;
                cnt1 += 1;
            }
            while j < word_len && word.chars().nth(j) == word.chars().nth(j + 1) {
                j += 1;
                cnt2 += 1;
            }
            if cnt1 < cnt2 || (cnt1 > cnt2 && cnt1 < 2) {
                return false;
            }
            i += 1;
            j += 1;
        }
        i == s_len && j == word_len
    }
}