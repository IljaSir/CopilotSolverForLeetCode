impl Solution {
    pub fn min_add_to_make_valid(s: String) -> i32 {
        
        let mut count = 0;
        let mut stack = vec![];
        for c in s.chars() {
            if c == '(' {
                stack.push(c);
            } else {
                if stack.len() > 0 {
                    stack.pop();
                } else {
                    count += 1;
                }
            }
        }
        count + stack.len() as i32
    }
}