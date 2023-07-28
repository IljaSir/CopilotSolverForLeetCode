impl Solution {
    pub fn common_chars(words: Vec<String>) -> Vec<String> {
        
        let mut res = vec![];
        for i in 0..26 {
            let mut min = 101;
            for word in &words {
                let mut count = 0;
                for c in word.chars() {
                    if c as u8 - 97 == i as u8 {
                        count += 1;
                    }
                }
                if min > count {
                    min = count;
                }
            }
            for _ in 0..min {
                let mut s = String::new();
                s.push((i as u8 + 97) as char);
                res.push(s);
            }
        }
        res
    }
}