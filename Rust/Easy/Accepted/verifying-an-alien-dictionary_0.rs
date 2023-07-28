impl Solution {
    pub fn is_alien_sorted(words: Vec<String>, order: String) -> bool {
        
        let mut map = [0; 26];
        for (i, c) in order.chars().enumerate() {
            map[c as usize - 'a' as usize] = i;
        }
        for i in 1..words.len() {
            let mut a = words[i - 1].chars();
            let mut b = words[i].chars();
            loop {
                match (a.next(), b.next()) {
                    (Some(x), Some(y)) => {
                        if x != y {
                            if map[x as usize - 'a' as usize] > map[y as usize - 'a' as usize] {
                                return false;
                            } else {
                                break;
                            }
                        }
                    }
                    (Some(_), None) => return false,
                    (None, _) => break,
                }
            }
        }
        true
    }
}