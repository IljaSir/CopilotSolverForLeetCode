impl Solution {
    pub fn balanced_string_split(s: String) -> i32 {
        
        let mut count = 0;
        let mut result = 0;
        for c in s.chars() {
            if c == 'L' {
                count += 1;
            } else {
                count -= 1;
            }
            if count == 0 {
                result += 1;
            }
        }
        result
    }
}