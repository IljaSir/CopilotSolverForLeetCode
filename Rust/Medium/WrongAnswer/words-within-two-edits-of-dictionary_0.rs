impl Solution {
    pub fn two_edit_words(queries: Vec<String>, dictionary: Vec<String>) -> Vec<String> {
        
        let mut d = std::collections::HashSet::new();
        for word in dictionary {
            d.insert(word);
        }
        let mut result = Vec::new();
        for word in queries {
            if d.contains(&word) {
                result.push(word);
            } else {
                let mut found = false;
                for i in 0..word.len() {
                    let mut new_word = word.clone();
                    new_word.remove(i);
                    if d.contains(&new_word) {
                        found = true;
                        break;
                    }
                }
                if !found {
                    for i in 0..word.len() {
                        for j in 0..26 {
                            let mut new_word = word.clone();
                            new_word.insert(i, (b'a' + j) as char);
                            if d.contains(&new_word) {
                                found = true;
                                break;
                            }
                        }
                        if found {
                            break;
                        }
                    }
                }
                if found {
                    result.push(word);
                }
            }
        }
        result
    }
}