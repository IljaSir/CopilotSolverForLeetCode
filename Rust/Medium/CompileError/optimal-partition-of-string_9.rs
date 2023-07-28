impl Solution {
    pub fn partition_string(s: String) -> i32 {
        
        let mut max = 0;
        let mut count = 0;
        for i in 0..s.len() {
            max = max.max(s.bytes().nth(i).unwrap() - 97);
            if i == max {
                count += 1;
            }
        }
        count
    }
}