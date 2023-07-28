impl Solution {
    pub fn closet_target(words: Vec<String>, target: String, start_index: i32) -> i32 {
        
        let mut min = std::i32::MAX;
        let mut i = start_index as usize;
        while min > 0 {
            if words[i] == target {
                break;
            }
            min -= 1;
            i = (i + 1) % words.len();
        }
        while min > 0 {
            if words[i] == target {
                break;
            }
            min -= 1;
            i = (i + words.len() - 1) % words.len();
        }
        if min == 0 {
            -1
        } else {
            min
        }
    }
}