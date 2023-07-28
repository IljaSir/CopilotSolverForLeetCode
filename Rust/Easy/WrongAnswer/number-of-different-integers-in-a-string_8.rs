impl Solution {
    pub fn num_different_integers(word: String) -> i32 {
        
        let mut count = 0;
        let mut num = false;
        let mut set = std::collections::HashSet::new();
        for c in word.chars() {
            if c.is_numeric() {
                if !num {
                    count += 1;
                    num = true;
                }
            } else {
                if num {
                    num = false;
                    set.insert(count);
                    count = 0;
                }
            }
        }
        if num {
            set.insert(count);
        }
        set.len() as i32
    }
}