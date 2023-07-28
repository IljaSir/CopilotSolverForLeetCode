impl Solution {
    pub fn num_ways(s: String) -> i32 {
        
        let mut ones = 0;
        for c in s.chars() {
            ones += if c == '1' { 1 } else { 0 };
        }
        if ones % 3 != 0 {
            return 0;
        }
        if ones == 0 {
            return ((s.len() - 1) * (s.len() - 2) / 2) as i32 % 1000000007;
        }
        let mut left = 0;
        let mut right = 0;
        let mut count = 0;
        for c in s.chars() {
            left += if c == '1' { 1 } else { 0 };
            if left == ones / 3 {
                right += 1;
            }
            if left == ones * 2 / 3 {
                count += right;
            }
        }
        count as i32 % 1000000007
    }
}