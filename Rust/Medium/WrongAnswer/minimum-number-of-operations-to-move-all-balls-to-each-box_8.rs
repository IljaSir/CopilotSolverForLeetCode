impl Solution {
    pub fn min_operations(boxes: String) -> Vec<i32> {
        
        let n = boxes.len();
        let mut res = vec![0; n];

        let mut cnt = 0;
        let mut sum = 0;
        for i in 0..n {
            if boxes.as_bytes()[i] == b'1' {
                cnt += 1;
                sum += i as i32;
            }
            res[i] = sum;
        }

        cnt = 0;
        sum = 0;
        for i in (0..n).rev() {
            if boxes.as_bytes()[i] == b'1' {
                cnt += 1;
                sum += (n - i - 1) as i32;
            }
            res[i] += sum - cnt * (n - i - 1) as i32;
        }

        res
    }
}