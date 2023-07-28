impl Solution {
    pub fn find_words(words: Vec<String>) -> Vec<String> {
        
        let mut ret = Vec::new();
        let mut rows = Vec::new();
        rows.push("qwertyuiop".to_string());
        rows.push("asdfghjkl".to_string());
        rows.push("zxcvbnm".to_string());
        for word in words {
            let mut row = 0;
            let mut i = 0;
            while i < 3 {
                let mut j = 0;
                while j < rows[i].len() {
                    if word.to_lowercase().contains(&rows[i][j..j+1]) {
                        row += 1;
                        break;
                    }
                    j += 1;
                }
                if row > 1 {
                    break;
                }
                i += 1;
            }
            if row == 1 {
                ret.push(word);
            }
        }
        ret
    }
}