impl Solution {
    pub fn remove_outer_parentheses(s: String) -> String {
        
        let mut result = String::new();
        let mut count = 0;
        for i in s.chars() {
            match i {
                '(' => {
                    if count > 0 {
                        result.push(i);
                    }
                    count += 1;
                },
                ')' => {
                    if count > 1 {
                        result.push(i);
                    }
                    count -= 1;
                },
                _ => (),
            }
        }
        result
    }
}