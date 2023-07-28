impl Solution {
    pub fn find_ladders(begin_word: String, end_word: String, word_list: Vec<String>) -> Vec<Vec<String>> {
        
        let mut ret = vec![];
        let mut word_list = word_list;
        if !word_list.contains(&end_word) {
            return ret;
        }
        let mut visited = vec![false; word_list.len()];
        let mut cur = vec![vec![begin_word]];
        let mut next = vec![];
        let mut found = false;
        while !cur.is_empty() {
            for path in cur {
                let last = path.last().unwrap();
                for (i, word) in word_list.iter().enumerate() {
                    if visited[i] {
                        continue;
                    }
                    if Self::diff(last, word) == 1 {
                        let mut path = path.clone();
                        path.push(word.clone());
                        if word == end_word {
                            ret.push(path);
                            found = true;
                        } else {
                            next.push(path);
                        }
                    }
                }
            }
            if found {
                break;
            }
            for path in next.iter() {
                let last = path.last().unwrap();
                for (i, word) in word_list.iter().enumerate() {
                    if visited[i] {
                        continue;
                    }
                    if Self::diff(last, word) == 1 {
                        visited[i] = true;
                    }
                }
            }
            cur = next;
            next = vec![];
        }
        ret
    }
    fn diff(a: &str, b: &str) -> usize {
        let mut diff = 0;
        for (c, d) in a.chars().zip(b.chars()) {
            if c != d {
                diff += 1;
            }
        }
        diff
    }
}