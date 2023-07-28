impl Solution {
    pub fn ladder_length(begin_word: String, end_word: String, word_list: Vec<String>) -> i32 {
        
        let mut word_list: Vec<String> = word_list;
        word_list.push(begin_word);
        let mut graph = vec![vec![]; word_list.len()];
        for i in 0..word_list.len() {
            for j in i+1..word_list.len() {
                if Solution::one_char_diff(&word_list[i], &word_list[j]) {
                    graph[i].push(j);
                    graph[j].push(i);
                }
            }
        }
        let mut visited = vec![false; word_list.len()];
        let mut queue = VecDeque::new();
        let mut level = 0;
        queue.push_back((word_list.len()-1, 1));
        visited[word_list.len()-1] = true;
        while let Some((node, l)) = queue.pop_front() {
            if word_list[node] == end_word {
                level = l;
                break;
            }
            for &next in &graph[node] {
                if !visited[next] {
                    queue.push_back((next, l+1));
                    visited[next] = true;
                }
            }
        }
        level
    }
    fn one_char_diff(word1: &str, word2: &str) -> bool {
        let mut diff = 0;
        for i in 0..word1.len() {
            if word1.chars().nth(i).unwrap() != word2.chars().nth(i).unwrap() {
                diff += 1;
            }
        }
        diff == 1
    }
}