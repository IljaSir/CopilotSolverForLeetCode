impl Solution {
    pub fn h_index(citations: Vec<i32>) -> i32 {
        

        let (mut l, mut r) = (0, citations.len());
        while l < r {
            let m = (l + r) / 2;
            if citations[m] >= (citations.len() - m) as i32 {
                r = m;
            } else {
                l = m + 1;
            }
        }
        (citations.len() - l) as i32
    }
}