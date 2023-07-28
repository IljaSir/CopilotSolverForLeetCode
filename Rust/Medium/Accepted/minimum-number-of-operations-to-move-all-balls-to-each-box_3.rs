impl Solution {
    pub fn min_operations(boxes: String) -> Vec<i32> {
        
        let mut res = vec![0; boxes.len()];
        let mut left = 0;
        let mut right = 0;
        let mut count = 0;
        for i in 1..boxes.len() {
            if boxes.chars().nth(i-1).unwrap() == '1' {
                left += 1;
            }
            count += left;
            res[i] += count;
        }
        count = 0;
        for i in (0..boxes.len()-1).rev() {
            if boxes.chars().nth(i+1).unwrap() == '1' {
                right += 1;
            }
            count += right;
            res[i] += count;
        }
        res
    }
}