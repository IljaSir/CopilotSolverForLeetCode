impl Solution {
    pub fn partition_string(s: String) -> i32 {
        
        let mut max = 0;
        let mut ans = 0;
        for (i, c) in s.chars().enumerate() {
            max = max.max(c as usize - 'a' as usize);
            if i == max {
                ans += 1;
            }
        }
        ans
    }
}