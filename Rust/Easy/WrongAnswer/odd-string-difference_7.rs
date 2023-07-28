impl Solution {
    pub fn odd_string(words: Vec<String>) -> String {
        
        let mut res = String::new();
        for w in words {
            let mut diff = vec![];
            let mut odd = 0;
            let mut even = 0;
            for i in 1..w.len() {
                let d = w.as_bytes()[i] as i32 - w.as_bytes()[i - 1] as i32;
                diff.push(d);
                if i % 2 == 0 {
                    even += d;
                } else {
                    odd += d;
                }
            }
            if even != odd {
                res = w;
                break;
            }
        }
        res
    }
}