impl Solution {
    pub fn can_change(start: String, target: String) -> bool {
        
        let mut count = 0;
        for i in 0..start.len() {
            if start.as_bytes()[i] != target.as_bytes()[i] {
                count += 1;
            }
        }
        count % 2 == 0
    }
}