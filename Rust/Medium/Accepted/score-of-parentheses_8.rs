impl Solution {
    pub fn score_of_parentheses(s: String) -> i32 {
        
        let mut stack = vec![];
        for c in s.chars() {
            match c {
                '(' => stack.push(0),
                ')' => {
                    let mut tmp = 0;
                    while let Some(top) = stack.pop() {
                        if top == 0 {
                            if tmp == 0 {
                                stack.push(1);
                            } else {
                                stack.push(2 * tmp);
                            }
                            break;
                        } else {
                            tmp += top;
                        }
                    }
                }
                _ => unreachable!(),
            }
        }
        stack.iter().sum()
    }
}