impl Solution {
    pub fn ladder_length(begin_word: String, end_word: String, word_list: Vec<String>) -> i32 {
        
        let mut word_list = word_list;
        let mut q = std::collections::VecDeque::new();
        q.push_back((begin_word, 1));
        while let Some((word, step)) = q.pop_front() {
            if word == end_word {
                return step;
            }
            let mut i = 0;
            while i < word_list.len() {
                if Solution::is_adjacent(&word, &word_list[i]) {
                    let word = word_list.remove(i);
                    q.push_back((word, step + 1));
                } else {
                    i += 1;
                }
            }
        }
        0
    }
    fn is_adjacent(word1: &str, word2: &str) -> bool {
        let mut diff = 0;
        for (c1, c2) in word1.chars().zip(word2.chars()) {
            if c1 != c2 {
                diff += 1;
            }
        }
        diff == 1
    }
}