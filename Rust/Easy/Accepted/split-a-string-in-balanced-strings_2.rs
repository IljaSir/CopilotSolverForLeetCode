impl Solution {
    pub fn balanced_string_split(s: String) -> i32 {
        
        let mut count = 0;
        let mut r = 0;
        let mut l = 0;
        for c in s.chars() {
            if c == 'R' {
                r += 1;
            } else {
                l += 1;
            }
            if r == l {
                count += 1;
            }
        }
        count
    }
}