impl Solution {
    pub fn decode_string(s: String) -> String {
        

        let mut stack = Vec::new();
        for c in s.chars() {
            if c != ']' {
                stack.push(c);
            } else {
                let mut decoded = String::new();
                while let Some(c) = stack.pop() {
                    if c == '[' {
                        break;
                    }
                    decoded.push(c);
                }
                decoded = decoded.chars().rev().collect();
                let mut num = String::new();
                while let Some(c) = stack.pop() {
                    if c.is_digit(10) {
                        num.push(c);
                    } else {
                        stack.push(c);
                        break;
                    }
                }
                let num = num.chars().rev().collect::<String>().parse::<usize>().unwrap();
                for _ in 0..num {
                    for c in decoded.chars() {
                        stack.push(c);
                    }
                }
            }
        }
        stack.into_iter().collect()
    }
}