impl Solution {
    pub fn remove_occurrences(s: String, part: String) -> String {
        
        let mut s = s.chars().collect::<Vec<char>>();
        let part = part.chars().collect::<Vec<char>>();
        let mut i = 0;
        while i <= s.len() - part.len() {
            let mut j = 0;
            while j < part.len() && s[i + j] == part[j] {
                j += 1;
            }
            if j == part.len() {
                s.drain(i..i + j);
            } else {
                i += 1;
            }
        }
        s.into_iter().collect()
    }
}