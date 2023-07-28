impl Solution {
    pub fn is_alien_sorted(words: Vec<String>, order: String) -> bool {
        
        let order = order.chars().enumerate().map(|(i, c)| (c, i)).collect::<std::collections::HashMap<char, usize>>();
        let mut words = words.into_iter().map(|s| s.chars().collect::<Vec<char>>()).collect::<Vec<Vec<char>>>();
        for i in 0..words.len() - 1 {
            let mut j = 0;
            while j < words[i].len() && j < words[i + 1].len() && words[i][j] == words[i + 1][j] {
                j += 1;
            }
            if j == words[i].len() {
                continue;
            }
            if j == words[i + 1].len() {
                return false;
            }
            if order[&words[i][j]] > order[&words[i + 1][j]] {
                return false;
            }
        }
        true
    }
}