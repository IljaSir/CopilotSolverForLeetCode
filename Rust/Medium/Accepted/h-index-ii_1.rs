impl Solution {
    pub fn h_index(citations: Vec<i32>) -> i32 {
        

        let n = citations.len();
        let mut l = 0;
        let mut r = n;
        while l < r {
            let m = l + (r - l) / 2;
            if citations[m] < (n - m) as i32 {
                l = m + 1;
            } else {
                r = m;
            }
        }
        (n - l) as i32
    }
}