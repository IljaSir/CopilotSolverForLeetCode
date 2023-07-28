impl Solution {
    pub fn ladder_length(begin_word: String, end_word: String, word_list: Vec<String>) -> i32 {
        
        let mut dict: HashSet<String> = HashSet::new();
        for word in word_list {
            dict.insert(word);
        }
        if !dict.contains(&end_word) {
            return 0;
        }
        let mut q1: VecDeque<String> = VecDeque::new();
        let mut q2: VecDeque<String> = VecDeque::new();
        let mut step = 1;
        q1.push_back(begin_word);
        while !q1.is_empty() {
            let word = q1.pop_front().unwrap();
            let mut chars: Vec<char> = word.chars().collect();
            for i in 0..chars.len() {
                let old = chars[i];
                for c in 'a' as u8..'z' as u8 + 1 {
                    chars[i] = c as char;
                    let new_word = chars.iter().collect();
                    if new_word == end_word {
                        return step + 1;
                    }
                    if dict.contains(&new_word) {
                        q2.push_back(new_word.clone());
                        dict.remove(&new_word);
                    }
                }
                chars[i] = old;
            }
            if q1.is_empty() {
                step += 1;
                std::mem::swap(&mut q1, &mut q2);
            }
        }
        0
    }
}