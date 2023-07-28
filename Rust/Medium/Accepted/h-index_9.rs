impl Solution {
    pub fn h_index(citations: Vec<i32>) -> i32 {
        

        let mut citations = citations;
        citations.sort();
        let n = citations.len();
        let mut h = 0;
        for i in 0..n {
            let c = citations[i];
            let t = n - i;
            if c >= t as i32 {
                h = t as i32;
                break;
            }
        }
        h
    }
}