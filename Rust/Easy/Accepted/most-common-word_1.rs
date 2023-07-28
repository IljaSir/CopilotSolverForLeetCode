impl Solution {
    pub fn most_common_word(paragraph: String, banned: Vec<String>) -> String {
        
        let mut banned_set = std::collections::HashSet::new();
        for word in banned {
            banned_set.insert(word);
        }
        let mut words = paragraph
            .split(|c: char| !c.is_alphabetic())
            .filter(|word| !word.is_empty())
            .map(|word| word.to_lowercase())
            .filter(|word| !banned_set.contains(word))
            .collect::<Vec<String>>();
        words.sort();
        let mut cur_word = "".to_string();
        let mut cur_count = 0;
        let mut max_word = "".to_string();
        let mut max_count = 0;
        for word in words {
            if word != cur_word {
                if cur_count > max_count {
                    max_count = cur_count;
                    max_word = cur_word;
                }
                cur_word = word;
                cur_count = 1;
            } else {
                cur_count += 1;
            }
        }
        if cur_count > max_count {
            max_count = cur_count;
            max_word = cur_word;
        }
        max_word
    }
}