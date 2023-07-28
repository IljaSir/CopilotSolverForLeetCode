impl Solution {
    pub fn balanced_string_split(s: String) -> i32 {
        
        let mut lcount = 0;
        let mut rcount = 0;
        let mut count = 0;
        for c in s.chars() {
            if c == 'L' {
                lcount += 1;
            } else if c == 'R' {
                rcount += 1;
            }
            if lcount == rcount {
                count += 1;
            }
        }
        count
    }
}