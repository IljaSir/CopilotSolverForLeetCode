impl Solution {
    pub fn closet_target(words: Vec<String>, target: String, start_index: i32) -> i32 {
        
        let mut min_distance = std::i32::MAX;
        let mut min_index = -1;
        let mut i = 0;
        for word in words {
            if word == target {
                let distance = (i - start_index).abs();
                if distance < min_distance {
                    min_distance = distance;
                    min_index = i;
                }
            }
            i = i + 1;
        }
        min_distance
    }
}