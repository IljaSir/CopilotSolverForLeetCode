impl Solution {
    pub fn find_ladders(begin_word: String, end_word: String, word_list: Vec<String>) -> Vec<Vec<String>> {
        
        let mut word_list: Vec<Vec<char>> = word_list.into_iter().map(|s| s.chars().collect()).collect();
        let begin_word: Vec<char> = begin_word.chars().collect();
        let end_word: Vec<char> = end_word.chars().collect();
        let mut result: Vec<Vec<String>> = vec![];
        let mut cur: Vec<Vec<char>> = vec![begin_word.clone()];
        let mut visited: Vec<Vec<char>> = vec![];
        let mut found = false;
        while !cur.is_empty() {
            let mut next: Vec<Vec<char>> = vec![];
            for word in cur {
                if word == end_word {
                    result.push(word.into_iter().collect());
                    found = true;
                } else {
                    for i in 0..word.len() {
                        for c in 'a' as u8..='z' as u8 {
                            let mut new_word = word.clone();
                            new_word[i] = c as char;
                            if !word_list.contains(&new_word) || visited.contains(&new_word) {
                                continue;
                            }
                            next.push(new_word.clone());
                            visited.push(new_word);
                        }
                    }
                }
            }
            if found {
                break;
            }
            cur = next;
        }
        result
    }
}