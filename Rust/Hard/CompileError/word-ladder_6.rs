impl Solution {
    pub fn ladder_length(begin_word: String, end_word: String, word_list: Vec<String>) -> i32 {
        
        let mut word_list = word_list;
        let mut queue = VecDeque::new();
        queue.push_back((begin_word, 0));
        while let Some((word, level)) = queue.pop_front() {
            if word == end_word {
                return level + 1;
            }
            for i in 0..word.len() {
                for j in 0..26 {
                    let mut new_word = word.clone();
                    new_word.replace_range(i..i + 1, &('a' as u8 + j).to_string());
                    if let Some(pos) = word_list.iter().position(|x| x == &new_word) {
                        queue.push_back((word_list.remove(pos), level + 1));
                    }
                }
            }
        }
        0
    }
}