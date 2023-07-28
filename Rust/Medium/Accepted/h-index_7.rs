impl Solution {
    pub fn h_index(citations: Vec<i32>) -> i32 {
        

        let mut citations = citations;
        citations.sort();
        let len = citations.len();
        let mut h = 0;
        for i in 0..len {
            if citations[i] >= (len - i) as i32 {
                h = len - i;
                break;
            }
        }
        h as i32
    }
}