impl Solution {
    pub fn num_matching_subseq(s: String, words: Vec<String>) -> i32 {
        
        let mut res: i32 = 0;
        for w in words {
            let mut s = s.clone();
            let mut w = w;
            let mut i = 0;
            while i < w.len() {
                let c = w.chars().nth(i).unwrap();
                let mut found = false;
                while let Some(j) = s.find(c) {
                    found = true;
                    s = s[j+1..].to_string();
                    break;
                }
                if !found {
                    break;
                }
                i += 1;
            }
            if i == w.len() {
                res += 1;
            }
        }
        res
    }
}