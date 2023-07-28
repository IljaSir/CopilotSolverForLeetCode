impl Solution {
    pub fn closet_target(words: Vec<String>, target: String, start_index: i32) -> i32 {
        
        let mut min_distance = std::i32::MAX;
        let mut result = -1;
        for (i, word) in words.iter().enumerate() {
            if word == &target {
                let distance = (i as i32 - start_index).abs();
                if distance < min_distance {
                    min_distance = distance;
                    result = i as i32;
                }
            }
        }
        result
    }
}