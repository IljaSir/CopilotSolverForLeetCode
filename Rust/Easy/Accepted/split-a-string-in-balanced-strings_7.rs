impl Solution {
    pub fn balanced_string_split(s: String) -> i32 {
        
        let mut count = 0;
        let mut count_L = 0;
        let mut count_R = 0;
        for c in s.chars() {
            if c == 'L' {
                count_L += 1;
            } else if c == 'R' {
                count_R += 1;
            }
            if count_L == count_R {
                count += 1;
            }
        }
        count
    }
}