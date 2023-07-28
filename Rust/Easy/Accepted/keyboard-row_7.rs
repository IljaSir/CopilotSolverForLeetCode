impl Solution {
    pub fn find_words(words: Vec<String>) -> Vec<String> {
        
        let mut result = Vec::new();
        let mut row = 0;
        let mut rows = Vec::new();
        rows.push("qwertyuiop");
        rows.push("asdfghjkl");
        rows.push("zxcvbnm");
        for word in words {
            let mut i = 0;
            while i < rows.len() {
                if rows[i].contains(word.chars().nth(0).unwrap().to_lowercase().to_string().as_str()) {
                    row = i;
                    break;
                }
                i += 1;
            }
            let mut is_same_row = true;
            for c in word.chars() {
                if !rows[row].contains(c.to_lowercase().to_string().as_str()) {
                    is_same_row = false;
                    break;
                }
            }
            if is_same_row {
                result.push(word);
            }
        }
        result
    }
}