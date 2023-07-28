impl Solution {
    pub fn find_words(words: Vec<String>) -> Vec<String> {
        
        let mut res: Vec<String> = Vec::new();
        let mut rows: Vec<Vec<char>> = Vec::new();
        rows.push(vec!['q', 'w', 'e', 'r', 't', 'y', 'u', 'i', 'o', 'p']);
        rows.push(vec!['a', 's', 'd', 'f', 'g', 'h', 'j', 'k', 'l']);
        rows.push(vec!['z', 'x', 'c', 'v', 'b', 'n', 'm']);
        for word in words {
            let mut flag = true;
            let mut row = 0;
            for (i, c) in word.chars().enumerate() {
                if i == 0 {
                    for (j, r) in rows.iter().enumerate() {
                        if r.contains(&c.to_ascii_lowercase()) {
                            row = j;
                            break;
                        }
                    }
                } else {
                    if !rows[row].contains(&c.to_ascii_lowercase()) {
                        flag = false;
                        break;
                    }
                }
            }
            if flag {
                res.push(word);
            }
        }
        res
    }
}