impl Solution {
    pub fn rearrange_characters(s: String, target: String) -> i32 {
        
        let mut count = vec![0; 26];
        for c in s.chars() {
            count[(c as u8 - b'a') as usize] += 1;
        }
        let mut target_count = vec![0; 26];
        for c in target.chars() {
            target_count[(c as u8 - b'a') as usize] += 1;
        }
        let mut max = 0;
        let mut min = 0;
        for i in 0..26 {
            if target_count[i] > 0 {
                if count[i] == 0 {
                    return 0;
                }
                max = max.max(count[i] / target_count[i]);
                min = min.max(count[i] % target_count[i]);
            }
        }
        if min == 0 {
            max
        } else {
            max + 1
        }
    }
}