impl Solution {
    pub fn minimum_score(s: String, t: String) -> i32 {
        
        let mut s = s.chars().collect::<Vec<char>>();
        let mut t = t.chars().collect::<Vec<char>>();
        let mut i = 0;
        let mut j = 0;
        let mut ans = 0;
        while i < s.len() {
            while i < s.len() && s[i] != t[j] {
                i += 1;
            }
            let mut i = i;
            let mut j = j;
            while i < s.len() && j < t.len() && s[i] == t[j] {
                i += 1;
                j += 1;
            }
            if i < s.len() && j < t.len() {
                ans = ans.max(i - j + 1);
            }
            if i == s.len() {
                break;
            }
            i += 1;
            j += 1;
        }
        ans as i32
    }
}