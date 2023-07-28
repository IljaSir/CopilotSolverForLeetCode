impl Solution {
    pub fn h_index(citations: Vec<i32>) -> i32 {
        

        let n = citations.len();
        let mut count = vec![0; n + 1];
        for &x in &citations {
            if x > n as i32 {
                count[n] += 1;
            } else {
                count[x as usize] += 1;
            }
        }
        let mut sum = 0;
        for i in (0..=n).rev() {
            sum += count[i];
            if sum >= i {
                return i as i32;
            }
        }
        0
    }
}