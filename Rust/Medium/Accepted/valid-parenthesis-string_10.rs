impl Solution {
    pub fn check_valid_string(s: String) -> bool {
        

        let mut stack = Vec::new();
        let mut star = Vec::new();
        for (i, c) in s.chars().enumerate() {
            match c {
                '(' => stack.push(i),
                '*' => star.push(i),
                ')' => {
                    if let Some(_) = stack.pop() {
                        continue;
                    }
                    if let Some(_) = star.pop() {
                        continue;
                    }
                    return false;
                }
                _ => unreachable!(),
            }
        }
        while let Some(i) = stack.pop() {
            if let Some(j) = star.pop() {
                if i > j {
                    return false;
                }
            } else {
                return false;
            }
        }
        true
    }
}