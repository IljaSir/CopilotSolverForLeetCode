impl Solution {
    pub fn balanced_string_split(s: String) -> i32 {
        
        let mut c = 0;
        let mut r = 0;
        for x in s.chars() {
            if x == 'R' {
                c += 1;
            } else {
                c -= 1;
            }
            if c == 0 {
                r += 1;
            }
        }
        r
    }
}