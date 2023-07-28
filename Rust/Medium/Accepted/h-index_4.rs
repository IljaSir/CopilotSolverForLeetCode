impl Solution {
    pub fn h_index(citations: Vec<i32>) -> i32 {
        

        let mut citations = citations;
        citations.sort();
        let mut h = 0;
        for i in (0..citations.len()).rev() {
            if citations[i] >= h + 1 {
                h += 1;
            } else {
                break;
            }
        }
        h
    }
}