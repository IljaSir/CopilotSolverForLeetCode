impl Solution {
    pub fn find_ladders(begin_word: String, end_word: String, word_list: Vec<String>) -> Vec<Vec<String>> {
        
        let mut word_list = word_list;
        let mut word_set = std::collections::HashSet::new();
        for word in &word_list {
            word_set.insert(word);
        }
        let mut queue = std::collections::VecDeque::new();
        queue.push_back(vec![begin_word.clone()]);
        let mut res = vec![];
        let mut min_len = std::usize::MAX;
        while !queue.is_empty() {
            let mut size = queue.len();
            let mut visited = std::collections::HashSet::new();
            while size > 0 {
                let mut path = queue.pop_front().unwrap();
                let last_word = path.last().unwrap();
                if last_word == &end_word {
                    if path.len() <= min_len {
                        min_len = path.len();
                        res.push(path);
                    } else {
                        break;
                    }
                } else {
                    for i in 0..last_word.len() {
                        for c in 'a' as u8..='z' as u8 {
                            let mut new_word = last_word.clone().into_bytes();
                            new_word[i] = c;
                            let new_word = String::from_utf8(new_word).unwrap();
                            if word_set.contains(&new_word) && !visited.contains(&new_word) {
                                let mut new_path = path.clone();
                                new_path.push(new_word.clone());
                                queue.push_back(new_path);
                                visited.insert(new_word);
                            }
                        }
                    }
                }
                size -= 1;
            }
        }
        res
    }
}