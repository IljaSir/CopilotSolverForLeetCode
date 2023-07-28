impl Solution {
    pub fn ladder_length(begin_word: String, end_word: String, word_list: Vec<String>) -> i32 {
        
        let begin_word = begin_word.as_bytes();
        let end_word = end_word.as_bytes();
        let word_list = word_list
            .into_iter()
            .map(|s| s.as_bytes().to_vec())
            .collect::<Vec<_>>();
        let mut res = 0;
        let mut q = vec![(begin_word.to_vec(), 1)];
        let mut visited = vec![false; word_list.len()];
        while let Some((w, c)) = q.pop() {
            if w == end_word {
                res = c;
                break;
            }
            for (i, w2) in word_list.iter().enumerate() {
                if visited[i] {
                    continue;
                }
                let mut diff = 0;
                for j in 0..w.len() {
                    if w[j] != w2[j] {
                        diff += 1;
                    }
                }
                if diff == 1 {
                    visited[i] = true;
                    q.push((w2.to_vec(), c + 1));
                }
            }
        }
        res
    }
}