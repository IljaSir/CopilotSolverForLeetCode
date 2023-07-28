impl Solution {
    pub fn find_words(words: Vec<String>) -> Vec<String> {
        
        let mut result: Vec<String> = Vec::new();
        let row1 = "qwertyuiopQWERTYUIOP";
        let row2 = "asdfghjklASDFGHJKL";
        let row3 = "zxcvbnmZXCVBNM";
        for word in words {
            let mut row = 0;
            let mut is_same_row = true;
            for c in word.chars() {
                let mut r = 0;
                if row1.contains(c) {
                    r = 1;
                } else if row2.contains(c) {
                    r = 2;
                } else if row3.contains(c) {
                    r = 3;
                }
                if row == 0 {
                    row = r;
                } else if row != r {
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