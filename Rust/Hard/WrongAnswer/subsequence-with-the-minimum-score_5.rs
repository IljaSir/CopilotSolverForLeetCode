impl Solution {
    pub fn minimum_score(s: String, t: String) -> i32 {
        
        let mut s = s.chars().collect::<Vec<char>>();
        let mut t = t.chars().collect::<Vec<char>>();
        let mut i = 0;
        let mut j = 0;
        let mut count = 0;
        while i < s.len() && j < t.len() {
            if s[i] == t[j] {
                i += 1;
                j += 1;
            } else {
                i += 1;
                count += 1;
            }
        }
        count
    }
}