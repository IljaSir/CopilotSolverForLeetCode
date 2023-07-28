impl Solution {
    pub fn h_index(citations: Vec<i32>) -> i32 {
        

        let mut citations = citations;
        citations.sort();
        let n = citations.len();
        for i in 0..n {
            if citations[i] >= (n - i) as i32 {
                return (n - i) as i32;
            }
        }
        0
    }
}