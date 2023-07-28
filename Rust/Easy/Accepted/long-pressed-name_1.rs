impl Solution {
    pub fn is_long_pressed_name(name: String, typed: String) -> bool {
        
        let mut i = 0;
        let mut j = 0;
        let name = name.as_bytes();
        let typed = typed.as_bytes();
        while j < typed.len() {
            if i < name.len() && name[i] == typed[j] {
                i += 1;
                j += 1;
            } else if j > 0 && typed[j] == typed[j-1] {
                j += 1;
            } else {
                return false;
            }
        }
        i == name.len()
    }
}