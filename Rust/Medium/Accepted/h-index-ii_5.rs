impl Solution {
    pub fn h_index(citations: Vec<i32>) -> i32 {
        

        let mut l = 0;
        let mut r = citations.len();
        while l < r {
            let m = l + (r - l) / 2;
            if citations[m] as usize >= citations.len() - m {
                r = m;
            } else {
                l = m + 1;
            }
        }
        (citations.len() - l) as i32
    }
}