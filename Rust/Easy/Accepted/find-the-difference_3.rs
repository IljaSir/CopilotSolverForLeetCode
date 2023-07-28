impl Solution {
    pub fn find_the_difference(s: String, t: String) -> char {
        
        let mut s = s.chars().collect::<Vec<_>>();
        let mut t = t.chars().collect::<Vec<_>>();
        s.sort();
        t.sort();
        for i in 0..s.len() {
            if s[i] != t[i] {
                return t[i];
            }
        }
        t[t.len() - 1]
    }
}