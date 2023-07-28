impl Solution {
    pub fn expressive_words(s: String, words: Vec<String>) -> i32 {
        
        let mut res = 0;
        for word in words {
            if Solution::is_stretchy(&s, &word) {
                res += 1;
            }
        }
        res
    }
    fn is_stretchy(s: &String, word: &String) -> bool {
        let mut i = 0;
        let mut j = 0;
        let s = s.as_bytes();
        let word = word.as_bytes();
        while i < s.len() && j < word.len() {
            if s[i] != word[j] {
                return false;
            }
            let mut cnt1 = 0;
            let mut cnt2 = 0;
            while i < s.len() && s[i] == s[i + cnt1] {
                cnt1 += 1;
            }
            while j < word.len() && word[j] == word[j + cnt2] {
                cnt2 += 1;
            }
            if cnt1 < cnt2 || (cnt1 != cnt2 && cnt1 < 3) {
                return false;
            }
            i += cnt1;
            j += cnt2;
        }
        i == s.len() && j == word.len()
    }
}