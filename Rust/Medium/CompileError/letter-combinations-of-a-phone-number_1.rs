impl Solution {
    pub fn letter_combinations(digits: String) -> Vec<String> {
        

        let mut ans = vec![];
        if digits.len() == 0 {
            return ans;
        }
        let mut map = HashMap::new();
        map.insert('2', "abc");
        map.insert('3', "def");
        map.insert('4', "ghi");
        map.insert('5', "jkl");
        map.insert('6', "mno");
        map.insert('7', "pqrs");
        map.insert('8', "tuv");
        map.insert('9', "wxyz");
        let mut queue = vec!["".to_string()];
        for c in digits.chars() {
            let mut next_queue = vec![];
            for s in queue {
                for c in map[&c].chars() {
                    next_queue.push(s.clone() + &c.to_string());
                }
            }
            queue = next_queue;
        }
        ans = queue;
        ans
    }
}