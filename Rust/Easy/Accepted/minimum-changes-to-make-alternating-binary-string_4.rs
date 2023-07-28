impl Solution {
    pub fn min_operations(s: String) -> i32 {
        
        let mut count = 0;
        let mut count2 = 0;
        for (i, c) in s.chars().enumerate() {
            if i % 2 == 0 {
                if c == '1' {
                    count += 1;
                } else {
                    count2 += 1;
                }
            } else {
                if c == '0' {
                    count += 1;
                } else {
                    count2 += 1;
                }
            }
        }
        count.min(count2)
    }
}