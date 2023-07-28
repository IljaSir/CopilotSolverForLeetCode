impl Solution {
    pub fn score_of_parentheses(s: String) -> i32 {
        
        let mut stack = vec![];
        for c in s.chars() {
            if c == '(' {
                stack.push(c);
            } else {
                let mut sum = 0;
                while let Some(c) = stack.pop() {
                    if c == '(' {
                        if sum == 0 {
                            sum = 1;
                        } else {
                            sum *= 2;
                        }
                        stack.push(sum as u8 as char);
                        break;
                    } else {
                        sum += c.to_digit(10).unwrap() as i32;
                    }
                }
            }
        }
        stack.iter().map(|c| c.to_digit(10).unwrap() as i32).sum()
    }
}