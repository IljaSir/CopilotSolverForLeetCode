impl Solution {
    pub fn min_add_to_make_valid(s: String) -> i32 {
        
        let mut stack = Vec::new();
        let mut result = 0;
        for c in s.chars() {
            match c {
                '(' => stack.push(c),
                ')' => {
                    if stack.len() > 0 {
                        stack.pop();
                    } else {
                        result += 1;
                    }
                }
                _ => (),
            }
        }
        result + stack.len() as i32
    }
}