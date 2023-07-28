impl Solution {
    pub fn min_add_to_make_valid(s: String) -> i32 {
        
        let mut stack: Vec<char> = vec![];
        let mut count = 0;
        for c in s.chars() {
            if c == '(' {
                stack.push(c);
            } else {
                if let Some('(') = stack.pop() {
                } else {
                    count += 1;
                }
            }
        }
        count + stack.len() as i32
    }
}