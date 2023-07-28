impl Solution {
    pub fn shortest_palindrome(s: String) -> String {
        
        let mut s = s.chars().collect::<Vec<char>>();
        let mut t = s.clone();
        t.reverse();
        let mut i = 0;
        for j in 0..s.len() {
            if s[j] == t[i] {
                i += 1;
            }
        }
        if i == s.len() {
            return s.into_iter().collect::<String>();
        }
        let mut r = t[..i].to_vec();
        r.reverse();
        r.extend(s);
        r.into_iter().collect::<String>()
    }
}