impl Solution {
    pub fn min_operations(s: String) -> i32 {
        
        let mut even = 0;
        let mut odd = 0;
        for (i, c) in s.chars().enumerate() {
            if i % 2 == 0 {
                if c == '1' {
                    even += 1;
                } else {
                    odd += 1;
                }
            } else {
                if c == '0' {
                    even += 1;
                } else {
                    odd += 1;
                }
            }
        }
        even.min(odd)
    }
}