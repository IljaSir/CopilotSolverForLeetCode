impl Solution {
    pub fn score_of_students(s: String, answers: Vec<i32>) -> i32 {
        
        let mut res = 0;
        for &a in &answers {
            let mut stack = vec![];
            let mut cur = 0;
            let mut is_op = false;
            let mut is_mul = false;
            for c in s.chars() {
                if c == '+' || c == '*' {
                    if is_op {
                        if is_mul {
                            stack.push(stack.pop().unwrap() * cur);
                        } else {
                            stack.push(cur);
                        }
                    } else {
                        stack.push(cur);
                    }
                    cur = 0;
                    is_op = true;
                    is_mul = c == '*';
                } else {
                    cur = cur * 10 + (c as u8 - b'0') as i32;
                    is_op = false;
                }
            }
            if is_op {
                if is_mul {
                    stack.push(stack.pop().unwrap() * cur);
                } else {
                    stack.push(cur);
                }
            } else {
                stack.push(cur);
            }
            let mut ret = 0;
            while !stack.is_empty() {
                ret += stack.pop().unwrap();
            }
            if ret == a {
                res += 5;
            } else if a == stack[0] + stack[1] * stack[2] {
                res += 2;
            }
        }
        res
    }
}