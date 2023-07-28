impl Solution {
    pub fn is_long_pressed_name(name: String, typed: String) -> bool {
        
        let mut last = ' ';
        let mut i = 0;
        let mut j = 0;
        while i < name.len() && j < typed.len() {
            if name.as_bytes()[i] == typed.as_bytes()[j] {
                last = name.as_bytes()[i] as char;
                i += 1;
                j += 1;
            } else if typed.as_bytes()[j] == last as u8 {
                j += 1;
            } else {
                return false;
            }
        }
        if i < name.len() {
            return false;
        }
        while j < typed.len() {
            if typed.as_bytes()[j] != last as u8 {
                return false;
            }
            j += 1;
        }
        return true;
    }
}