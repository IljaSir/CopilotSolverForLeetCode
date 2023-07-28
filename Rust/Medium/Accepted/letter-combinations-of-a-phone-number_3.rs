impl Solution {
    pub fn letter_combinations(digits: String) -> Vec<String> {
        

        if digits.len() == 0 {
            return vec![];
        }
        let mut res = Vec::new();
        let mut cur = String::new();
        Self::backtrack(&digits, 0, &mut cur, &mut res);
        res
    }
    fn backtrack(digits: &String, idx: usize, cur: &mut String, res: &mut Vec<String>) {
        if idx == digits.len() {
            res.push(cur.clone());
            return;
        }
        let ch = digits.chars().nth(idx).unwrap();
        let mut letters = match ch {
            '2' => "abc",
            '3' => "def",
            '4' => "ghi",
            '5' => "jkl",
            '6' => "mno",
            '7' => "pqrs",
            '8' => "tuv",
            '9' => "wxyz",
            _ => "",
        };
        for i in 0..letters.len() {
            cur.push(letters.chars().nth(i).unwrap());
            Self::backtrack(digits, idx + 1, cur, res);
            cur.pop();
        }
    }
}