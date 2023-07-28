impl Solution {
    pub fn is_covered(ranges: Vec<Vec<i32>>, left: i32, right: i32) -> bool {
        
        let mut num = 0;
        for i in left..=right {
            for j in 0..ranges.len() {
                if i >= ranges[j][0] && i <= ranges[j][1] {
                    num += 1;
                    break;
                }
            }
        }
        num == (right - left + 1)
    }
}