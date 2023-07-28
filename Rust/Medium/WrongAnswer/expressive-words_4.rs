impl Solution {
    pub fn expressive_words(s: String, words: Vec<String>) -> i32 {
        
        let mut count = 0;
        for word in words {
            let mut i = 0;
            let mut j = 0;
            while i < s.len() && j < word.len() {
                if s.chars().nth(i) == word.chars().nth(j) {
                    let mut i1 = i;
                    let mut j1 = j;
                    while i1 < s.len() && s.chars().nth(i1) == s.chars().nth(i) {
                        i1 += 1;
                    }
                    while j1 < word.len() && word.chars().nth(j1) == word.chars().nth(j) {
                        j1 += 1;
                    }
                    if i1 - i >= 3 || i1 - i == j1 - j {
                        i = i1;
                        j = j1;
                    } else {
                        break;
                    }
                } else {
                    break;
                }
            }
            if i == s.len() && j == word.len() {
                count += 1;
            }
        }
        count
    }
}