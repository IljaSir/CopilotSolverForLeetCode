impl Solution {
    pub fn match_replacement(s: String, sub: String, mappings: Vec<Vec<char>>) -> bool {
        
        let mut sub = sub.chars().collect::<Vec<_>>();
        let mut s = s.chars().collect::<Vec<_>>();
        let mut i = 0;
        while i < sub.len() {
            let mut j = 0;
            while j < mappings.len() {
                if sub[i] == mappings[j][0] {
                    sub[i] = mappings[j][1];
                    break;
                }
                j += 1;
            }
            i += 1;
        }
        let mut i = 0;
        let mut j = 0;
        while i < s.len() && j < sub.len() {
            if s[i] == sub[j] {
                j += 1;
            }
            i += 1;
        }
        j == sub.len()
    }
}