impl Solution {
    pub fn balanced_string_split(s: String) -> i32 {
        
        let mut i = 0;
        let mut count = 0;
        for c in s.chars() {
            if c == 'L' {
                i += 1;
            } else {
                i -= 1;
            }
            if i == 0 {
                count += 1;
            }
        }
        count
    }
}