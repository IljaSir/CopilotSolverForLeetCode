impl Solution {
    pub fn is_match(s: String, p: String) -> bool {
        
        let (s,p): (Vec<char>,Vec<char>) = (s.chars().collect(),p.chars().collect());
        let (mut i,mut j): (usize,usize) = (0,0);
        let (mut star,mut ss): (usize,usize) = (0,0);
        while i < s.len() {
            if j < p.len() && (s[i] == p[j] || p[j] == '.') {
                i += 1;
                j += 1;
            } else if j < p.len() && p[j] == '*' {
                star = j;
                j += 1;
                ss = i;
            } else if star != 0 {
                j = star + 1;
                ss += 1;
                i = ss;
            } else {
                return false;
            }
        }
        while j < p.len() && p[j] == '*' {
            j += 1;
        }
        j == p.len()
    }
}