impl Solution {
    pub fn find_words(words: Vec<String>) -> Vec<String> {
        
        let mut res: Vec<String> = Vec::new();
        let mut row1: Vec<char> = vec!['q','w','e','r','t','y','u','i','o','p'];
        let mut row2: Vec<char> = vec!['a','s','d','f','g','h','j','k','l'];
        let mut row3: Vec<char> = vec!['z','x','c','v','b','n','m'];
        for word in words.iter() {
            let mut flag = 0;
            for ch in word.chars() {
                if flag == 0 {
                    if row1.contains(&ch.to_ascii_lowercase()) {
                        flag = 1;
                    } else if row2.contains(&ch.to_ascii_lowercase()) {
                        flag = 2;
                    } else if row3.contains(&ch.to_ascii_lowercase()) {
                        flag = 3;
                    }
                } else {
                    if flag == 1 && !row1.contains(&ch.to_ascii_lowercase()) {
                        flag = -1;
                        break;
                    } else if flag == 2 && !row2.contains(&ch.to_ascii_lowercase()) {
                        flag = -1;
                        break;
                    } else if flag == 3 && !row3.contains(&ch.to_ascii_lowercase()) {
                        flag = -1;
                        break;
                    }
                }
            }
            if flag > 0 {
                res.push(word.clone());
            }
        }
        res
    }
}