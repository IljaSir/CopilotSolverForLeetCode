impl Solution {
    pub fn num_sub(s: String) -> i32 {
        
        let mut count = 0;
        let mut sum = 0;
        for c in s.chars() {
            if c == '1' {
                count += 1;
            } else {
                sum += count * (count + 1) / 2;
                count = 0;
            }
        }
        sum += count * (count + 1) / 2;
        sum as i32 % (1_000_000_000 + 7)
    }
}