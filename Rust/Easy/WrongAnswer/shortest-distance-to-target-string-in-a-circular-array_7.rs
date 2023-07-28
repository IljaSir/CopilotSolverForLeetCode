impl Solution {
    pub fn closet_target(words: Vec<String>, target: String, start_index: i32) -> i32 {
        
        let mut n = words.len();
        let mut i = start_index as usize;
        let mut j = start_index as usize;
        let mut k = 0;
        let mut res = n as i32;
        while k < n {
            if words[i] == target {
                res = res.min((i as i32 - start_index).abs());
            }
            if words[j] == target {
                res = res.min((j as i32 - start_index).abs());
            }
            i = (i + 1) % n;
            j = (j + n - 1) % n;
            k += 1;
        }
        res
    }
}