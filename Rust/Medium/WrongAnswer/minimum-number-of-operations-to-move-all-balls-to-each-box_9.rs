impl Solution {
    pub fn min_operations(boxes: String) -> Vec<i32> {
        
        let mut res = Vec::with_capacity(boxes.len());
        let mut sum = 0;
        let mut cnt = 0;
        let mut i = 0;
        for c in boxes.chars() {
            res.push(sum);
            if c == '1' {
                cnt += 1;
                sum += cnt;
            }
            i += 1;
        }
        sum = 0;
        cnt = 0;
        i = boxes.len() - 1;
        for c in boxes.chars().rev() {
            res[i] += sum;
            if c == '1' {
                cnt += 1;
                sum += cnt;
            }
            i -= 1;
        }
        res
    }
}