impl Solution {
    pub fn num_sub(s: String) -> i32 {
        
        let mut count = 0;
        let mut result = 0;
        for c in s.chars() {
            if c == '1' {
                count += 1;
            } else {
                result += count * (count + 1) / 2;
                count = 0;
            }
        }
        result += count * (count + 1) / 2;
        result % 1000000007
    }
}