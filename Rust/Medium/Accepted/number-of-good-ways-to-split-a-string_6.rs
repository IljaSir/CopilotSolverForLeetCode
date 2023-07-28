impl Solution {
    pub fn num_splits(s: String) -> i32 {
        
        let mut left: Vec<i32> = vec![0; 26];
        let mut right: Vec<i32> = vec![0; 26];
        let mut lcount = 0;
        let mut rcount = 0;
        let mut count = 0;
        for c in s.chars() {
            let idx = (c as u8 - 'a' as u8) as usize;
            if right[idx] == 0 {
                rcount += 1;
            }
            right[idx] += 1;
        }
        for c in s.chars() {
            let idx = (c as u8 - 'a' as u8) as usize;
            if left[idx] == 0 {
                lcount += 1;
            }
            left[idx] += 1;
            right[idx] -= 1;
            if right[idx] == 0 {
                rcount -= 1;
            }
            if lcount == rcount {
                count += 1;
            }
        }
        count
    }
}