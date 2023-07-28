impl Solution {
    pub fn find_ladders(begin_word: String, end_word: String, word_list: Vec<String>) -> Vec<Vec<String>> {
        
        let mut word_list = word_list;
        if !word_list.contains(&end_word) {
            return vec![];
        }
        let mut word_set = word_list.iter().map(|s| s.as_str()).collect::<HashSet<_>>();
        let mut queue = vec![vec![begin_word]];
        let mut res = vec![];
        let mut found = false;
        while !queue.is_empty() {
            let mut next_queue = vec![];
            let mut visited = HashSet::new();
            for path in queue {
                let last_word = path.last().unwrap();
                for i in 0..last_word.len() {
                    for c in b'a'..=b'z' {
                        let mut new_word = last_word.clone().into_bytes();
                        new_word[i] = c;
                        let new_word = String::from_utf8(new_word).unwrap();
                        if word_set.contains(&new_word.as_str()) && !visited.contains(&new_word) {
                            let mut new_path = path.clone();
                            new_path.push(new_word.clone());
                            if new_word == end_word {
                                found = true;
                                res.push(new_path);
                            } else {
                                next_queue.push(new_path);
                            }
                            visited.insert(new_word);
                        }
                    }
                }
            }
            if found {
                break;
            }
            queue = next_queue;
        }
        res
    }
}