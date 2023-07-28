impl Solution {
    pub fn is_long_pressed_name(name: String, typed: String) -> bool {
        
        let mut i = 0;
        let mut j = 0;
        let name = name.chars().collect::<Vec<_>>();
        let typed = typed.chars().collect::<Vec<_>>();
        while i < name.len() && j < typed.len() {
            if name[i] == typed[j] {
                i += 1;
                j += 1;
            } else if j > 0 && typed[j] == typed[j - 1] {
                j += 1;
            } else {
                return false;
            }
        }
        if i == name.len() {
            while j < typed.len() {
                if typed[j] != typed[j - 1] {
                    return false;
                }
                j += 1;
            }
            return true;
        } else {
            return false;
        }
    }
}