impl Solution {
    pub fn num_different_integers(word: String) -> i32 {
        
        let mut set = std::collections::HashSet::new();
        let mut str = String::new();
        for c in word.chars() {
            if c.is_digit(10) {
                str.push(c);
            } else {
                if !str.is_empty() {
                    let mut i = 0;
                    while i < str.len() && str.as_bytes()[i] == b'0' {
                        i += 1;
                    }
                    set.insert(str[i..].to_string());
                    str.clear();
                }
            }
        }
        if !str.is_empty() {
            let mut i = 0;
            while i < str.len() && str.as_bytes()[i] == b'0' {
                i += 1;
            }
            set.insert(str[i..].to_string());
        }
        set.len() as i32
    }
}