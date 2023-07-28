impl Solution {
    pub fn make_good(s: String) -> String {
        
        let mut stack = vec![];
        for ch in s.chars() {
            match stack.last() {
                Some(&c) => {
                    if (c as u8 - ch as u8).abs() == 32 {
                        stack.pop();
                    } else {
                        stack.push(ch);
                    }
                }
                None => {
                    stack.push(ch);
                }
            }
        }
        stack.iter().collect()
    }
}