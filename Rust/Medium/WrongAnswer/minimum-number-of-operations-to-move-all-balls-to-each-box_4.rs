impl Solution {
    pub fn min_operations(boxes: String) -> Vec<i32> {
        
        let mut result = vec![0; boxes.len()];
        let mut left = 0;
        let mut right = 0;
        let mut left_cost = 0;
        let mut right_cost = 0;
        for i in 0..boxes.len() {
            if boxes.as_bytes()[i] == b'1' {
                left_cost += left;
                right += 1;
            }
            if boxes.as_bytes()[boxes.len() - 1 - i] == b'1' {
                right_cost += right;
                left += 1;
            }
            result[i] += left_cost;
            result[boxes.len() - 1 - i] += right_cost;
        }
        result
    }
}