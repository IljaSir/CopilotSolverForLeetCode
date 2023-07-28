impl Solution {
    pub fn letter_combinations(digits: String) -> Vec<String> {
        

        let mut ret = vec![];
        let mut queue = vec![];
        let map = vec!["abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"];
        for c in digits.chars() {
            let i = c as usize - '2' as usize;
            if i < map.len() {
                if queue.is_empty() {
                    for c in map[i].chars() {
                        queue.push(c.to_string());
                    }
                } else {
                    let mut new_queue = vec![];
                    for s in &queue {
                        for c in map[i].chars() {
                            let mut new_s = s.clone();
                            new_s.push(c);
                            new_queue.push(new_s);
                        }
                    }
                    queue = new_queue;
                }
            }
        }
        ret.append(&mut queue);
        ret
    }
}