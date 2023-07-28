impl Solution {
    pub fn ladder_length(begin_word: String, end_word: String, word_list: Vec<String>) -> i32 {
        
        let mut word_list = word_list;
        let mut queue = vec![begin_word];
        let mut visited = vec![false; word_list.len()];
        let mut result = 0;
        while !queue.is_empty() {
            let mut new_queue = vec![];
            result += 1;
            for word in queue {
                if word == end_word {
                    return result;
                }
                for i in 0..word_list.len() {
                    if visited[i] {
                        continue;
                    }
                    if is_adjacent(&word, &word_list[i]) {
                        new_queue.push(word_list[i].clone());
                        visited[i] = true;
                    }
                }
            }
            queue = new_queue;
        }
        0
    }
}