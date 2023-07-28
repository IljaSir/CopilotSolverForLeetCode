impl Solution {
    pub fn is_long_pressed_name(name: String, typed: String) -> bool {
        
        let mut name = name.chars().peekable();
        let mut typed = typed.chars().peekable();
        while let Some(c) = name.next() {
            if let Some(&d) = typed.peek() {
                if c == d {
                    typed.next();
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }
        true
    }
}