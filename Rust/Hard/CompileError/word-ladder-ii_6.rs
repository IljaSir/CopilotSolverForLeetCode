impl Solution {
    pub fn find_ladders(begin_word: String, end_word: String, word_list: Vec<String>) -> Vec<Vec<String>> {
        
        let word_list: Vec<String> = word_list.into_iter().filter(|w| w != &begin_word).collect();
        let mut graph: HashMap<String, Vec<String>> = HashMap::new();
        let mut queue: VecDeque<(String, i32)> = VecDeque::new();
        let mut distance: HashMap<String, i32> = HashMap::new();
        let mut result: Vec<Vec<String>> = Vec::new();
        let mut min_distance: i32 = 0;
        let mut visited: HashSet<String> = HashSet::new();
        let mut path: Vec<String> = Vec::new();
        queue.push_back((begin_word.clone(), 0));
        distance.insert(begin_word.clone(), 0);
        while !queue.is_empty() {
            let (w, d) = queue.pop_front().unwrap();
            if min_distance != 0 && d > min_distance {
                break;
            }
            for i in 0..w.len() {
                for c in b'a'..=b'z' {
                    let mut s = w.clone();
                    s.replace_range(i..i+1, &String::from_utf8(vec![c]).unwrap());
                    if !visited.contains(&s) && word_list.contains(&s) {
                        if !graph.contains_key(&w) {
                            graph.insert(w.clone(), Vec::new());
                        }
                        graph.get_mut(&w).unwrap().push(s.clone());
                        if !distance.contains_key(&s) {
                            distance.insert(s.clone(), d + 1);
                            queue.push_back((s.clone(), d + 1));
                        }
                        if s == end_word {
                            min_distance = d + 1;
                        }
                    }
                }
            }
            visited.insert(w.clone());
        }
        if min_distance == 0 {
            return result;
        }
        path.push(begin_word);
        Solution::dfs(&begin_word, &end_word, &mut graph, &mut path, &mut result);
        result
    }
    fn dfs(begin_word: &String, end_word: &String, graph: &mut HashMap<String, Vec<String>>, path: &mut Vec<String>, result: &mut Vec<Vec<String>>) {
        if begin_word == end_word {
            result.push(path.clone());
            return;
        }
        if !graph.contains_key(begin_word) {
            return;
        }
        for w in graph.get(begin_word).unwrap
    }
}