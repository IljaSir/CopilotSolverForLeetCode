impl Solution {
    pub fn min_window(s: String, t: String) -> String {
        
        let mut t = t.chars().collect::<Vec<char>>();
        t.sort();
        let mut s = s.chars().collect::<Vec<char>>();
        s.sort();
        let mut i = 0;
        let mut j = 0;
        let mut ans = "".to_string();
        while i < s.len() && j < t.len() {
            if s[i] == t[j] {
                j += 1;
            }
            i += 1;
        }
        if j == t.len() {
            ans = s[..i].iter().collect();
        }
        ans
    }
}