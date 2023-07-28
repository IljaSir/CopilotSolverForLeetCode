impl Solution {
    pub fn min_operations(boxes: String) -> Vec<i32> {
        
        let mut res = vec![0; boxes.len()];
        let mut count = 0;
        let mut left = 0;
        let mut right = 0;
        for i in 0..boxes.len() {
            if boxes.as_bytes()[i] == b'1' {
                count += 1;
                right += i as i32;
            }
        }
        for i in 0..boxes.len() {
            res[i] = right - left;
            if boxes.as_bytes()[i] == b'1' {
                count -= 1;
                left += i as i32 + 1;
                right -= count;
            }
        }
        res
    }
}