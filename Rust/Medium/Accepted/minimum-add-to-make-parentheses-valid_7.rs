impl Solution {
    pub fn min_add_to_make_valid(s: String) -> i32 {
        
        let mut count = 0;
        let mut stack = 0;
        for i in s.chars() {
            if i == '(' {
                stack += 1;
            } else {
                if stack == 0 {
                    count += 1;
                } else {
                    stack -= 1;
                }
            }
        }
        count + stack
    }
}