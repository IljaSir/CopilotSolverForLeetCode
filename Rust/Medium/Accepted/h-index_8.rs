impl Solution {
    pub fn h_index(citations: Vec<i32>) -> i32 {
        

        let mut citations = citations;
        citations.sort();
        let mut h = 0;
        for i in 0..citations.len() {
            h = h.max((citations.len() - i) as i32).min(citations[i]);
        }
        h
    }
}