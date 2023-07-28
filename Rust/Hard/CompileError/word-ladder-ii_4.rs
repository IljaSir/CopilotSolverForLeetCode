impl Solution {
    pub fn find_ladders(begin_word: String, end_word: String, word_list: Vec<String>) -> Vec<Vec<String>> {
        
        let mut word_list: Vec<String> = word_list;
        let mut ans: Vec<Vec<String>> = Vec::new();
        let mut queue: Vec<(String, Vec<String>)> = Vec::new();
        queue.push((begin_word.clone(), vec![begin_word.clone()]));
        let mut min_len = 0;
        let mut visited: HashSet<String> = HashSet::new();
        while !queue.is_empty() {
            let (word, path) = queue.remove(0);
            if min_len > 0 && path.len() > min_len {
                break;
            }
            if word == end_word {
                ans.push(path);
                min_len = path.len();
                continue;
            }
            for i in 0..word.len() {
                let mut chars: Vec<char> = word.chars().collect();
                for c in 'a' as u8..'z' as u8 {
                    chars[i] = c as char;
                    let new_word = chars.iter().collect::<String>();
                    if word_list.contains(&new_word) && !visited.contains(&new_word) {
                        let mut new_path = path.clone();
                        new_path.push(new_word.clone());
                        queue.push((new_word, new_path));
                    }
                }
            }
            visited.insert(word);
        }
        ans
    }
}