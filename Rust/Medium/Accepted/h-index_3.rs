impl Solution {
    pub fn h_index(citations: Vec<i32>) -> i32 {
        

        let mut c = citations;
        c.sort();
        let mut i = 0;
        while i < c.len() && c[c.len() - 1 - i] > i as i32 {
            i += 1;
        }
        i as i32
    }
}