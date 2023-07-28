impl Solution {
    pub fn find_the_difference(s: String, t: String) -> char {
        
        let mut s: Vec<char> = s.chars().collect();
        let mut t: Vec<char> = t.chars().collect();
        s.sort();
        t.sort();
        let mut i = 0;
        while i < s.len() {
            if s[i] != t[i] {
                return t[i];
            }
            i += 1;
        }
        return t[i];
    }
}