impl Solution {
    pub fn min_operations(boxes: String) -> Vec<i32> {
        
        let mut res = vec![0; boxes.len()];
        let mut sum = 0;
        let mut count = 0;
        for (i, c) in boxes.chars().enumerate() {
            res[i] += sum;
            count += c as i32 - '0' as i32;
            sum += count;
        }
        sum = 0;
        count = 0;
        for (i, c) in boxes.chars().rev().enumerate() {
            let j = boxes.len() - i - 1;
            res[j] += sum;
            count += c as i32 - '0' as i32;
            sum += count;
        }
        res
    }
}