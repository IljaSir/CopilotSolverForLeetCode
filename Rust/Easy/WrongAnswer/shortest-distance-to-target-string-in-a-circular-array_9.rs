impl Solution {
    pub fn closet_target(words: Vec<String>, target: String, start_index: i32) -> i32 {
        
        let mut res = i32::max_value();
        let mut index = start_index;
        let mut flag = 0;
        while flag < 2 {
            let mut i = 0;
            while i < words.len() {
                if words[index as usize] == target {
                    res = res.min((i as i32).abs());
                    break;
                }
                i += 1;
                index = (index + 1) % words.len() as i32;
            }
            flag += 1;
            index = (index + words.len() as i32 - 1) % words.len() as i32;
        }
        if res == i32::max_value() {
            -1
        } else {
            res
        }
    }
}