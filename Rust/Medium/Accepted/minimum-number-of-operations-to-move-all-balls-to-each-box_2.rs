impl Solution {
    pub fn min_operations(boxes: String) -> Vec<i32> {
        
        let mut ret = vec![0; boxes.len()];
        let mut sum = 0;
        let mut cnt = 0;
        for i in 0..boxes.len() {
            ret[i] += sum;
            cnt += boxes.chars().nth(i).unwrap() as i32 - '0' as i32;
            sum += cnt;
        }
        sum = 0;
        cnt = 0;
        for i in (0..boxes.len()).rev() {
            ret[i] += sum;
            cnt += boxes.chars().nth(i).unwrap() as i32 - '0' as i32;
            sum += cnt;
        }
        ret
    }
}