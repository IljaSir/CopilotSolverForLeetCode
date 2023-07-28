impl Solution {
    pub fn minimum_length(s: String) -> i32 {
        
        let mut s: Vec<char> = s.chars().collect();
        let mut i = 0;
        let mut j = s.len() - 1;
        while i < j {
            if s[i] != s[j] {
                break;
            }
            let c = s[i];
            while i < s.len() && s[i] == c {
                i += 1;
            }
            while j > 0 && s[j] == c {
                j -= 1;
            }
        }
        (j as i32 - i as i32 + 1).max(0)
    }
}