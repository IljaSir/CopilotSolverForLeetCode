impl Solution {
    pub fn expressive_words(s: String, words: Vec<String>) -> i32 {
        
        let s: Vec<char> = s.chars().collect();
        let mut ans = 0;
        for w in words {
            let w: Vec<char> = w.chars().collect();
            let mut i = 0;
            let mut j = 0;
            while i < s.len() && j < w.len() {
                if s[i] != w[j] {
                    break;
                }
                let mut i1 = i;
                let mut j1 = j;
                while i1 < s.len() && s[i1] == s[i] {
                    i1 += 1;
                }
                while j1 < w.len() && w[j1] == w[j] {
                    j1 += 1;
                }
                if i1 - i < j1 - j {
                    break;
                }
                if i1 - i < 3 && i1 - i != j1 - j {
                    break;
                }
                i = i1;
                j = j1;
            }
            if i == s.len() && j == w.len() {
                ans += 1;
            }
        }
        ans
    }
}