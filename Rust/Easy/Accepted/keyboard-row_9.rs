impl Solution {
    pub fn find_words(words: Vec<String>) -> Vec<String> {
        
        let mut result = Vec::new();
        for word in words {
            let mut row = 0;
            for ch in word.chars() {
                let ch = ch.to_lowercase().next().unwrap();
                let mut cur_row = 0;
                if ch == 'q' || ch == 'w' || ch == 'e' || ch == 'r' || ch == 't' || ch == 'y' || ch == 'u' || ch == 'i' || ch == 'o' || ch == 'p' {
                    cur_row = 1;
                } else if ch == 'a' || ch == 's' || ch == 'd' || ch == 'f' || ch == 'g' || ch == 'h' || ch == 'j' || ch == 'k' || ch == 'l' {
                    cur_row = 2;
                } else {
                    cur_row = 3;
                }
                if row == 0 {
                    row = cur_row;
                } else if row != cur_row {
                    row = -1;
                    break;
                }
            }
            if row != -1 {
                result.push(word);
            }
        }
        result
    }
}