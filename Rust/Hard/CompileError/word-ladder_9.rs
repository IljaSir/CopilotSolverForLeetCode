impl Solution {
    pub fn ladder_length(begin_word: String, end_word: String, word_list: Vec<String>) -> i32 {
        
        let mut word_list: Vec<_> = word_list.into_iter().map(|s| s.as_bytes()).collect();
        let mut queue = Vec::new();
        let mut vis = vec![false; word_list.len()];
        let mut ans = 0;
        queue.push((begin_word.as_bytes(), 1));
        while !queue.is_empty() {
            let (word, step) = queue.remove(0);
            if word == end_word.as_bytes() {
                ans = step;
                break;
            }
            for i in 0..word_list.len() {
                if !vis[i] && word_list[i].len() == word.len() {
                    let mut diff = 0;
                    for j in 0..word.len() {
                        if word[j] != word_list[i][j] {
                            diff += 1;
                        }
                    }
                    if diff == 1 {
                        vis[i] = true;
                        queue.push((word_list[i], step + 1));
                    }
                }
            }
        }
        ans
    }
}