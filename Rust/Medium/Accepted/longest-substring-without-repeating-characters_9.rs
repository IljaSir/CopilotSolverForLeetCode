impl Solution {
    pub fn length_of_longest_substring(s: String) -> i32 {
        

        let mut max = 0;
        let mut count = 0;
        let mut last_seen = [0; 256];
        for (i, c) in s.chars().enumerate() {
            let idx = c as usize;
            if last_seen[idx] == 0 {
                count += 1;
            } else {
                let last_idx = last_seen[idx] - 1;
                if i as i32 - last_idx as i32 <= count {
                    count = i as i32 - last_idx as i32;
                } else {
                    count += 1;
                }
            }
            if count > max {
                max = count;
            }
            last_seen[idx] = i + 1;
        }
        max
    }
}