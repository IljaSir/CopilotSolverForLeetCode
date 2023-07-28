impl Solution {
    pub fn closet_target(words: Vec<String>, target: String, start_index: i32) -> i32 {
        
        let mut i = start_index;
        let mut j = start_index;
        let n = words.len();
        let mut count = 0;
        let mut ans = std::i32::MAX;
        loop {
            if i >= 0 && i < n as i32 && words[i as usize] == target {
                ans = ans.min(count);
                break;
            }
            if j >= 0 && j < n as i32 && words[j as usize] == target {
                ans = ans.min(count);
                break;
            }
            if i >= 0 && i < n as i32 {
                i -= 1;
            } else {
                i = n as i32 - 1;
            }
            if j >= 0 && j < n as i32 {
                j += 1;
            } else {
                j = 0;
            }
            count += 1;
        }
        ans
    }
}