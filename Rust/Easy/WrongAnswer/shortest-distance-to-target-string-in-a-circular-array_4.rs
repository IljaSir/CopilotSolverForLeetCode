impl Solution {
    pub fn closet_target(words: Vec<String>, target: String, start_index: i32) -> i32 {
        
        let mut res = i32::max_value();
        let mut prev = -1;
        for (i, word) in words.iter().enumerate() {
            if word == &target {
                if prev != -1 {
                    res = res.min((i as i32 - prev).abs());
                }
                prev = i as i32;
            }
        }
        let n = words.len() as i32;
        if prev != -1 {
            res = res.min((n - (prev - start_index).abs()).abs());
        }
        if res == i32::max_value() {
            -1
        } else {
            res
        }
    }
}