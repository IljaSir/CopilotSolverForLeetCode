impl Solution {
    pub fn delete_string(s: String) -> i32 {
        
        let mut count = 0;
        let mut i = 0;
        let mut j = 0;
        let mut s = s.chars().collect::<Vec<_>>();
        while i < s.len() {
            if s[i] == s[j] {
                j += 1;
                if j - i > 1 && j == s.len() {
                    count += 1;
                    i = j;
                    j = i;
                }
            } else {
                if j - i > 1 {
                    count += 1;
                    i = j;
                    j = i;
                } else {
                    i += 1;
                    j = i;
                }
            }
        }
        count
    }
}