impl Solution {
    pub fn h_index(citations: Vec<i32>) -> i32 {
        

        let n = citations.len();
        let mut l = 0;
        let mut r = n - 1;
        while l <= r {
            let m = (l + r) / 2;
            if citations[m] >= (n - m) as i32 {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        (n - l) as i32
    }
}