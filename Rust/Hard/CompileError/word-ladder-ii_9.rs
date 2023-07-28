impl Solution {
    pub fn find_ladders(begin_word: String, end_word: String, word_list: Vec<String>) -> Vec<Vec<String>> {
        
        let mut word_list = word_list;
        let mut res: Vec<Vec<String>> = vec![];
        let mut word_set: HashSet<String> = HashSet::new();
        word_set.insert(end_word.clone());
        let mut begin_set: HashSet<String> = HashSet::new();
        begin_set.insert(begin_word.clone());
        let mut end_set: HashSet<String> = HashSet::new();
        end_set.insert(end_word.clone());
        let mut visited: HashSet<String> = HashSet::new();
        let mut found = false;
        let mut next_begin_set: HashSet<String> = HashSet::new();
        let mut path_map: HashMap<String, Vec<Vec<String>>> = HashMap::new();
        path_map.insert(begin_word.clone(), vec![vec![begin_word.clone()]]);
        while !begin_set.is_empty() && !found {
            for word in &begin_set {
                word_set.remove(word);
            }
            for word in &begin_set {
                let mut chars: Vec<char> = word.chars().collect();
                for i in 0..chars.len() {
                    let old = chars[i];
                    for c in 'a'..='z' {
                        if c == old {
                            continue;
                        }
                        chars[i] = c;
                        let new_word = chars.iter().collect::<String>();
                        if word_set.contains(&new_word) {
                            next_begin_set.insert(new_word.clone());
                            let mut paths = path_map.get(word).unwrap().clone();
                            for path in &mut paths {
                                path.push(new_word.clone());
                            }
                            path_map.entry(new_word.clone()).or_insert(vec![]).append(&mut paths);
                            if end_set.contains(&new_word) {
                                found = true;
                            }
                        }
                    }
                    chars[i] = old;
                }
            }
            for word in &next_begin_set {
                visited.insert(word.clone());
            }
            begin_set = next_begin_set.clone();
            next_begin_set.clear();
            for word in &begin_set {
                if visited.contains(word) {
                    begin_set.remove(word);
                }
            }
        }
        if found {
            res.append(path_map.get(&end_word).unwrap());
        }
        res
    }
}