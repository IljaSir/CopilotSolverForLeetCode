impl Solution {
    pub fn find_ladders(begin_word: String, end_word: String, word_list: Vec<String>) -> Vec<Vec<String>> {
        
        let mut word_list = word_list;
        let mut ans = vec![];
        if !word_list.contains(&end_word) {
            return ans;
        }
        let mut queue = vec![(begin_word, vec![begin_word])];
        let mut visited = vec![false; word_list.len()];
        let mut min_len = usize::MAX;
        while !queue.is_empty() {
            let mut new_queue = vec![];
            for (word, path) in queue {
                if path.len() > min_len {
                    continue;
                }
                if word == end_word {
                    ans.push(path);
                    min_len = path.len();
                    continue;
                }
                for (i, w) in word_list.iter().enumerate() {
                    if visited[i] {
                        continue;
                    }
                    if word.len() != w.len() {
                        continue;
                    }
                    let mut diff = 0;
                    for (c1, c2) in word.chars().zip(w.chars()) {
                        if c1 != c2 {
                            diff += 1;
                        }
                    }
                    if diff == 1 {
                        let mut new_path = path.clone();
                        new_path.push(w.clone());
                        new_queue.push((w.clone(), new_path));
                        visited[i] = true;
                    }
                }
            }
            queue = new_queue;
        }
        ans
    }
}