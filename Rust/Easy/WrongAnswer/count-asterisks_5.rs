impl Solution {
    pub fn count_asterisks(s: String) -> i32 {
        
        let mut count = 0;
        let mut skip = false;
        for c in s.chars() {
            if c == '*' {
                if skip {
                    skip = false;
                } else {
                    skip = true;
                    count += 1;
                }
            } else if c == '|' {
                skip = false;
            }
        }
        count
    }
}