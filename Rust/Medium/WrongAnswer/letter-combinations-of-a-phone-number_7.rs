impl Solution {
    pub fn letter_combinations(digits: String) -> Vec<String> {
        

        let mut res: Vec<String> = Vec::new();
        let mut s: Vec<char> = Vec::new();
        let mut d = digits.chars().collect::<Vec<char>>();
        d.reverse();
        Self::backtrack(&mut res, &mut s, &mut d);
        res
    }
    fn backtrack(res: &mut Vec<String>, s: &mut Vec<char>, d: &mut Vec<char>) {
        if d.is_empty() {
            if !s.is_empty() {
                res.push(s.iter().rev().collect());
            }
        } else {
            let c = d.pop().unwrap();
            let cs = Self::get_chars(c);
            for c in cs {
                s.push(c);
                Self::backtrack(res, s, d);
                s.pop();
            }
            d.push(c);
        }
    }
    fn get_chars(c: char) -> Vec<char> {
        match c {
            '2' => vec!['a', 'b', 'c'],
            '3' => vec!['d', 'e', 'f'],
            '4' => vec!['g', 'h', 'i'],
            '5' => vec!['j', 'k', 'l'],
            '6' => vec!['m', 'n', 'o'],
            '7' => vec!['p', 'q', 'r', 's'],
            '8' => vec!['t', 'u', 'v'],
            '9' => vec!['w', 'x', 'y', 'z'],
            _ => vec![]
        }
    }
}