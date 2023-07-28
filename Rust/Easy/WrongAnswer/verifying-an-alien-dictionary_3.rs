impl Solution {
    pub fn is_alien_sorted(words: Vec<String>, order: String) -> bool {
        
        let mut index = [0; 26];
        for (i, c) in order.chars().enumerate() {
            index[c as usize - 'a' as usize] = i;
        }
        let mut words = words;
        words.sort_by(|a, b| {
            let a = a.as_bytes();
            let b = b.as_bytes();
            let mut i = 0;
            while i < a.len() && i < b.len() {
                let x = index[a[i] as usize - 'a' as usize];
                let y = index[b[i] as usize - 'a' as usize];
                if x < y {
                    return std::cmp::Ordering::Less;
                } else if x > y {
                    return std::cmp::Ordering::Greater;
                }
                i += 1;
            }
            if i < a.len() {
                std::cmp::Ordering::Greater
            } else if i < b.len() {
                std::cmp::Ordering::Less
            } else {
                std::cmp::Ordering::Equal
            }
        });
        words == words
    }
}