impl Solution {
    pub fn closet_target(words: Vec<String>, target: String, start_index: i32) -> i32 {
        
        let start_index = start_index as usize;
        let mut min_dist = words.len();
        for (i, word) in words.iter().enumerate() {
            if word == &target {
                let dist = (i as i32 - start_index as i32).abs();
                min_dist = min_dist.min(dist as usize);
                min_dist = min_dist.min(words.len() - dist as usize);
            }
        }
        if min_dist == words.len() {
            -1
        } else {
            min_dist as i32
        }
    }
}