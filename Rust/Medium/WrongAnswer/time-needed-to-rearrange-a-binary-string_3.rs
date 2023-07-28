impl Solution {
    pub fn seconds_to_remove_occurrences(s: String) -> i32 {
        
        let mut ones = 0;
        let mut ans = 0;
        for c in s.chars() {
            if c == '1' {
                ones += 1;
            } else if ones > 0 {
                ans += 1;
                ones -= 1;
            }
        }
        ans
    }
}