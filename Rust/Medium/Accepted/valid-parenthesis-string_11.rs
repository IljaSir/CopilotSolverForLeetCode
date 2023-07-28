impl Solution {
    pub fn check_valid_string(s: String) -> bool {
        

        let mut stack = vec![];
        let mut star = vec![];
        for (i, c) in s.chars().enumerate() {
            match c {
                '(' => stack.push(i),
                ')' => {
                    if let Some(_) = stack.pop() {
                    } else if let Some(_) = star.pop() {
                    } else {
                        return false;
                    }
                }
                '*' => star.push(i),
                _ => unreachable!(),
            }
        }
        while let Some(s) = star.pop() {
            if let Some(i) = stack.pop() {
                if i > s {
                    return false;
                }
            } else {
                break;
            }
        }
        stack.is_empty()
    }
}