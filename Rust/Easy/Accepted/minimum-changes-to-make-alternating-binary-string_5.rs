impl Solution {
    pub fn min_operations(s: String) -> i32 {
        
        let mut count = 0;
        let mut count1 = 0;
        let mut count2 = 0;
        for (i, c) in s.chars().enumerate() {
            if i % 2 == 0 {
                if c == '1' {
                    count1 += 1;
                } else {
                    count2 += 1;
                }
            } else {
                if c == '1' {
                    count2 += 1;
                } else {
                    count1 += 1;
                }
            }
        }
        std::cmp::min(count1, count2)
    }
}