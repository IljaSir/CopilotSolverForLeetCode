impl Solution {
    pub fn is_long_pressed_name(name: String, typed: String) -> bool {
        
        let mut i = 0;
        let mut j = 0;
        let mut last_c = ' ';
        while j < typed.len() {
            let c = typed.chars().nth(j).unwrap();
            if i < name.len() && name.chars().nth(i).unwrap() == c {
                i += 1;
                j += 1;
            } else if last_c == c {
                j += 1;
            } else {
                return false;
            }
            last_c = c;
        }
        i == name.len()
    }
}