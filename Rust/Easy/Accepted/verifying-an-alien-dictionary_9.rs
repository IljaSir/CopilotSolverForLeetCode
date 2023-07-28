impl Solution {
    pub fn is_alien_sorted(words: Vec<String>, order: String) -> bool {
        
        let mut order_vec = vec![0; 26];
        for (i, c) in order.chars().enumerate() {
            order_vec[c as usize - 97] = i;
        }
        let mut prev = words[0].clone();
        for word in words.iter().skip(1) {
            let mut i = 0;
            while i < word.len() && i < prev.len() && word[i..i+1] == prev[i..i+1] {
                i += 1;
            }
            if i < word.len() && i < prev.len() {
                if order_vec[word[i..i+1].chars().next().unwrap() as usize - 97] < order_vec[prev[i..i+1].chars().next().unwrap() as usize - 97] {
                    return false;
                }
            } else if i < prev.len() && i == word.len() {
                return false;
            }
            prev = word.clone();
        }
        true
    }
}