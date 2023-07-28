impl Solution {
    pub fn num_different_integers(word: String) -> i32 {
        
        let mut res: Vec<i32> = vec![];
        let mut num = String::new();
        for c in word.chars() {
            if c.is_digit(10) {
                num.push(c);
            } else {
                if !num.is_empty() {
                    res.push(num.parse::<i32>().unwrap());
                    num.clear();
                }
            }
        }
        if !num.is_empty() {
            res.push(num.parse::<i32>().unwrap());
        }
        res.sort();
        res.dedup();
        res.len() as i32
    }
}