impl Solution {
    pub fn balanced_string_split(s: String) -> i32 {
        
        let mut count = 0;
        let mut num = 0;
        for c in s.chars() {
            if c == 'L' {
                num += 1;
            } else {
                num -= 1;
            }
            if num == 0 {
                count += 1;
            }
        }
        count
    }
}