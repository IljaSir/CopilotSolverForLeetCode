impl Solution {
    pub fn check_valid_string(s: String) -> bool {
        

        let mut stack: Vec<char> = Vec::new();
        let mut star: Vec<usize> = Vec::new();
        for (i, c) in s.chars().enumerate() {
            match c {
                '(' => stack.push(c),
                '*' => star.push(i),
                ')' => {
                    if stack.is_empty() {
                        if star.is_empty() {
                            return false;
                        } else {
                            star.pop();
                        }
                    } else {
                        stack.pop();
                    }
                }
                _ => (),
            }
        }
        if stack.len() > star.len() {
            return false;
        }
        while !stack.is_empty() {
            let c = stack.pop().unwrap();
            if star.is_empty() {
                return false;
            } else {
                let i = star.pop().unwrap();
                if s.chars().nth(i).unwrap() == c {
                    return false;
                }
            }
        }
        true
    }
}