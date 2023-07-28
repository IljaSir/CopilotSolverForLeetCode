impl Solution {
    pub fn reformat_number(number: String) -> String {
        
        let mut num = number.replace(" ", "").replace("-", "");
        let mut res = String::new();
        let mut i = 0;
        while i < num.len() {
            let mut j = 0;
            while i < num.len() && j < 3 {
                res.push(num.chars().nth(i).unwrap());
                i += 1;
                j += 1;
            }
            if i < num.len() && i + 2 == num.len() {
                res.push('-');
                res.push(num.chars().nth(i).unwrap());
                res.push(num.chars().nth(i + 1).unwrap());
                break;
            } else if i < num.len() {
                res.push('-');
            }
        }
        res
    }
}