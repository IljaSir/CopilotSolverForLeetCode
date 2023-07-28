impl Solution {
    pub fn count_asterisks(s: String) -> i32 {
        
        let mut count = 0;
        let mut flag = false;
        for c in s.chars() {
            if c == '*' {
                if flag {
                    count += 1;
                }
            } else if c == '|' {
                flag = !flag;
            }
        }
        count
    }
}