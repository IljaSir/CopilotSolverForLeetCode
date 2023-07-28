impl Solution {
    pub fn longest_valid_parentheses(s: String) -> i32 {
        
        let mut stack: Vec<usize> = Vec::new();
        let mut longest = 0;
        let mut start = 0;
        for (i, c) in s.chars().enumerate() {
            match c {
                '(' => stack.push(i),
                ')' => {
                    if let Some(j) = stack.pop() {
                        if stack.is_empty() {
                            longest = std::cmp::max(longest, i - start + 1);
                        } else {
                            longest = std::cmp::max(longest, i - stack[stack.len() - 1]);
                        }
                    } else {
                        start = i + 1;
                    }
                }
                _ => unreachable!(),
            }
        }
        longest as i32
    }
}