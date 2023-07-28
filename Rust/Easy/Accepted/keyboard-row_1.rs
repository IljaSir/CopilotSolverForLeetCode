impl Solution {
    pub fn find_words(words: Vec<String>) -> Vec<String> {
        
        let mut result = vec![];
        let rows = vec![vec!['q', 'w', 'e', 'r', 't', 'y', 'u', 'i', 'o', 'p'], vec!['a', 's', 'd', 'f', 'g', 'h', 'j', 'k', 'l'], vec!['z', 'x', 'c', 'v', 'b', 'n', 'm']];
        for word in words {
            let mut row = 0;
            let mut same_row = true;
            let mut c = 0;
            for ch in word.chars() {
                let ch = ch.to_ascii_lowercase();
                if c == 0 {
                    for (i, r) in rows.iter().enumerate() {
                        if r.contains(&ch) {
                            row = i;
                            break;
                        }
                    }
                } else {
                    if !rows[row].contains(&ch) {
                        same_row = false;
                        break;
                    }
                }
                c += 1;
            }
            if same_row {
                result.push(word);
            }
        }
        result
    }
}