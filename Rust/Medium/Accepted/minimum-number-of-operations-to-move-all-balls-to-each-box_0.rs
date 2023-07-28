impl Solution {
    pub fn min_operations(boxes: String) -> Vec<i32> {
        
        let mut res: Vec<i32> = vec![0; boxes.len()];
        let mut sum = 0;
        let mut cnt = 0;
        for i in 0..boxes.len() {
            res[i] += sum;
            cnt += boxes.chars().nth(i).unwrap() as i32 - '0' as i32;
            sum += cnt;
        }
        sum = 0;
        cnt = 0;
        for i in (0..boxes.len()).rev() {
            res[i] += sum;
            cnt += boxes.chars().nth(i).unwrap() as i32 - '0' as i32;
            sum += cnt;
        }
        res
    }
}