impl Solution {
    pub fn ladder_length(begin_word: String, end_word: String, word_list: Vec<String>) -> i32 {
        
        let mut visited = vec![false; word_list.len()];
        let mut queue = Vec::new();
        let mut level = 1;
        queue.push(begin_word);
        while !queue.is_empty() {
            let size = queue.len();
            for _ in 0..size {
                let word = queue.remove(0);
                if word == end_word {
                    return level;
                }
                for i in 0..word_list.len() {
                    if !visited[i] && Self::is_adjacent(&word, &word_list[i]) {
                        queue.push(word_list[i].clone());
                        visited[i] = true;
                    }
                }
            }
            level += 1;
        }
        0
    }
    fn is_adjacent(word1: &str, word2: &str) -> bool {
        let mut diff = 0;
        for i in 0..word1.len() {
            if word1.chars().nth(i).unwrap() != word2.chars().nth(i).unwrap() {
                diff += 1;
                if diff > 1 {
                    return false;
                }
            }
        }
        diff == 1
    }
}