impl Solution {
    pub fn letter_combinations(digits: String) -> Vec<String> {
        

        let mut res = vec![];
        let mut v = vec![];
        let mut d = vec![];
        for c in digits.chars() {
            d.push(c.to_digit(10).unwrap() as usize);
        }
        let digits = d;
        let mut map = vec![
            vec![], vec![],
            vec!['a', 'b', 'c'],
            vec!['d', 'e', 'f'],
            vec!['g', 'h', 'i'],
            vec!['j', 'k', 'l'],
            vec!['m', 'n', 'o'],
            vec!['p', 'q', 'r', 's'],
            vec!['t', 'u', 'v'],
            vec!['w', 'x', 'y', 'z'],
        ];
        if digits.len() == 0 {
            return res;
        }
        for i in 0..digits.len() {
            v.push(0);
        }
        let mut i = 0;
        loop {
            let mut s = String::new();
            for j in 0..v.len() {
                let c = map[digits[j]][v[j]];
                s.push(c);
            }
            res.push(s);
            i = v.len() - 1;
            loop {
                if i < 0 {
                    return res;
                }
                v[i] += 1;
                if v[i] < map[digits[i]].len() {
                    break;
                }
                v[i] = 0;
                i -= 1;
            }
        }
        res
    }
}