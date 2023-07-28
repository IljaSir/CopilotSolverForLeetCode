impl Solution {
    pub fn find_ladders(begin_word: String, end_word: String, word_list: Vec<String>) -> Vec<Vec<String>> {
        
        let mut ans = vec![];
        let mut word_list = word_list;
        let mut word_set: HashSet<String> = HashSet::new();
        for word in word_list.iter() {
            word_set.insert(word.to_string());
        }
        if !word_set.contains(&end_word) {
            return ans;
        }
        let mut queue = VecDeque::new();
        queue.push_back(vec![begin_word.to_string()]);
        let mut visited = HashSet::new();
        let mut found = false;
        while !queue.is_empty() {
            let mut size = queue.len();
            visited.clear();
            while size > 0 {
                size -= 1;
                let mut path = queue.pop_front().unwrap();
                let word = path.last().unwrap();
                if word == &end_word {
                    ans.push(path);
                    found = true;
                }
                if found {
                    continue;
                }
                for i in 0..word.len() {
                    for j in 0..26 {
                        let mut new_word = word.to_string();
                        new_word.replace_range(i..i+1, &((b'a' + j) as char).to_string());
                        if word_set.contains(&new_word) && !visited.contains(&new_word) {
                            visited.insert(new_word.to_string());
                            let mut new_path = path.clone();
                            new_path.push(new_word.to_string());
                            queue.push_back(new_path);
                        }
                    }
                }
            }
            if found {
                break;
            }
        }
        ans
    }
}