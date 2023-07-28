impl Solution {
    pub fn closet_target(words: Vec<String>, target: String, start_index: i32) -> i32 {
        
        let mut res = std::i32::MAX;
        let mut last = -1;
        for i in 0..words.len() {
            if words[i] == target {
                if last != -1 {
                    res = res.min((i as i32 - last).abs());
                }
                last = i as i32;
            }
        }
        if last == -1 {
            return -1;
        }
        let n = words.len() as i32;
        res = res.min((start_index - last + n) % n);
        res = res.min((start_index - last - n) % n);
        res
    }
}