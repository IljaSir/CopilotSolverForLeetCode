impl Solution {
    pub fn num_sub(s: String) -> i32 {
        
        let mut count = 0;
        let mut result = 0;
        for c in s.chars() {
            if c == '0' {
                count = 0;
            } else {
                count += 1;
                result += count;
            }
        }
        result as i32 % 1_000_000_007
    }
}