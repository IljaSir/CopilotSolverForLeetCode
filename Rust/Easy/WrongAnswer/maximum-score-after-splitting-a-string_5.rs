impl Solution {
    pub fn max_score(s: String) -> i32 {
        
        let mut count = 0;
        let mut max = 0;
        for c in s.chars() {
            if c == '1' {
                count += 1;
            }
        }
        let mut count1 = 0;
        for c in s.chars() {
            if c == '0' {
                count1 += 1;
            } else {
                count -= 1;
            }
            if count + count1 > max {
                max = count + count1;
            }
        }
        max
    }
}