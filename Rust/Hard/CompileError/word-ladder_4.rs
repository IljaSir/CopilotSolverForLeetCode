impl Solution {
    pub fn ladder_length(begin_word: String, end_word: String, word_list: Vec<String>) -> i32 {
        
        let mut word_list = word_list;
        let mut word_set = std::collections::HashSet::new();
        for word in word_list.iter() {
            word_set.insert(word);
        }
        let mut queue = std::collections::VecDeque::new();
        queue.push_back((begin_word, 1));
        while let Some((word, step)) = queue.pop_front() {
            if word == end_word {
                return step;
            }
            for i in 0..word.len() {
                let mut chars = word.chars().collect::<Vec<char>>();
                for c in b'a'..=b'z' {
                    chars[i] = c as char;
                    let next_word = chars.iter().collect();
                    if word_set.contains(&next_word) {
                        queue.push_back((next_word, step + 1));
                        word_set.remove(&next_word);
                    }
                }
            }
        }
        0
    }
}