impl Solution {
    pub fn is_long_pressed_name(name: String, typed: String) -> bool {
        
        let mut i = 0;
        let mut j = 0;
        let name = name.as_bytes();
        let typed = typed.as_bytes();
        while i < name.len() && j < typed.len() {
            if name[i] == typed[j] {
                i += 1;
                j += 1;
            } else {
                if j == 0 || typed[j] != typed[j - 1] {
                    return false;
                }
                j += 1;
            }
        }
        if i < name.len() {
            return false;
        }
        while j < typed.len() {
            if typed[j] != typed[j - 1] {
                return false;
            }
            j += 1;
        }
        true
    }
}