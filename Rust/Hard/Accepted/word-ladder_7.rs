impl Solution {
    pub fn ladder_length(begin_word: String, end_word: String, word_list: Vec<String>) -> i32 {
        
        if begin_word == end_word {
            return 1;
        }
        let mut word_list = word_list;
        word_list.push(begin_word.clone());
        let mut map = std::collections::HashMap::new();
        for (i, word) in word_list.iter().enumerate() {
            for j in 0..word.len() {
                let mut s = word.clone();
                s.replace_range(j..j+1, "*");
                map.entry(s).or_insert(vec![]).push(i);
            }
        }
        let mut queue = std::collections::VecDeque::new();
        queue.push_back((0, begin_word.clone()));
        let mut visited = vec![false; word_list.len()];
        while let Some((step, word)) = queue.pop_front() {
            for j in 0..word.len() {
                let mut s = word.clone();
                s.replace_range(j..j+1, "*");
                if let Some(list) = map.get(&s) {
                    for &i in list {
                        if word_list[i] == end_word {
                            return step + 2;
                        }
                        if !visited[i] {
                            visited[i] = true;
                            queue.push_back((step + 1, word_list[i].clone()));
                        }
                    }
                }
            }
        }
        0
    }
}