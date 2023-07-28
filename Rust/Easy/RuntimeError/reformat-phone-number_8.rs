impl Solution {
    pub fn reformat_number(number: String) -> String {
        
        let mut v = number.chars().filter(|c| c.is_digit(10)).collect::<Vec<char>>();
        let len = v.len();
        let mut res = Vec::new();
        let mut i = 0;
        while i < len {
            res.push(v[i]);
            i += 1;
            if i % 3 == 0 && i < len - 4 {
                res.push('-');
            }
        }
        if len - i == 2 {
            res.push('-');
            res.push(v[i]);
            res.push(v[i + 1]);
        } else if len - i == 3 {
            res.push(v[i]);
            res.push('-');
            res.push(v[i + 1]);
            res.push(v[i + 2]);
        } else {
            res.push(v[i]);
            res.push(v[i + 1]);
        }
        res.iter().collect()
    }
}