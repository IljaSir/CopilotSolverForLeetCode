impl Solution {
    pub fn closet_target(words: Vec<String>, target: String, start_index: i32) -> i32 {
        
        let mut start_index = start_index as usize;
        let mut min = std::i32::MAX;
        let mut i = 0;
        while i < words.len() {
            if words[start_index] == target {
                min = min.min(i as i32);
            }
            start_index = (start_index + 1) % words.len();
            i += 1;
        }
        start_index = start_index as usize;
        i = 0;
        while i < words.len() {
            if words[start_index] == target {
                min = min.min(i as i32);
            }
            start_index = (start_index + words.len() - 1) % words.len();
            i += 1;
        }
        if min == std::i32::MAX {
            -1
        } else {
            min
        }
    }
}