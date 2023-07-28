impl Solution {
    pub fn expressive_words(s: String, words: Vec<String>) -> i32 {
        
        let mut res = 0;
        let mut s = s.chars().collect::<Vec<char>>();
        for word in words {
            let mut chars = word.chars().collect::<Vec<char>>();
            let mut i = 0;
            let mut j = 0;
            let mut ok = true;
            while i < s.len() && j < chars.len() {
                if s[i] != chars[j] {
                    ok = false;
                    break;
                }
                let mut cnt1 = 0;
                let mut cnt2 = 0;
                while i < s.len() && s[i] == s[i + cnt1] {
                    cnt1 += 1;
                }
                while j < chars.len() && chars[j] == chars[j + cnt2] {
                    cnt2 += 1;
                }
                if cnt1 < cnt2 || (cnt1 < 3 && cnt1 != cnt2) {
                    ok = false;
                    break;
                }
                i += cnt1;
                j += cnt2;
            }
            if ok && i == s.len() && j == chars.len() {
                res += 1;
            }
        }
        res
    }
}