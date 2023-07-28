impl Solution {
    pub fn is_long_pressed_name(name: String, typed: String) -> bool {
        
        let mut name = name.chars();
        let mut typed = typed.chars();
        let mut n = name.next();
        let mut t = typed.next();
        while n.is_some() && t.is_some() {
            if n == t {
                n = name.next();
                t = typed.next();
            } else if t == name.clone().next() {
                t = typed.next();
            } else {
                return false;
            }
        }
        if n.is_none() && t.is_none() {
            true
        } else if n.is_none() && t.is_some() {
            t == name.clone().next()
        } else {
            false
        }
    }
}