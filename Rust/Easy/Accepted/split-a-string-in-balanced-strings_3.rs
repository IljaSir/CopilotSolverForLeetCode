impl Solution {
    pub fn balanced_string_split(s: String) -> i32 {
        
        let mut count = 0;
        let mut sum = 0;
        for c in s.chars() {
            if c == 'R' {
                sum += 1;
            } else {
                sum -= 1;
            }
            if sum == 0 {
                count += 1;
            }
        }
        count
    }
}