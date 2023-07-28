impl Solution {
    pub fn min_operations(boxes: String) -> Vec<i32> {
        
        let mut r = vec![0; boxes.len()];
        let mut l = vec![0; boxes.len()];
        let mut sum = 0;
        let mut cnt = 0;
        for i in 0..boxes.len() {
            l[i] = sum;
            sum += cnt;
            cnt += (boxes.chars().nth(i).unwrap() as u8 - '0' as u8) as i32;
        }
        sum = 0;
        cnt = 0;
        for i in (0..boxes.len()).rev() {
            r[i] = sum;
            sum += cnt;
            cnt += (boxes.chars().nth(i).unwrap() as u8 - '0' as u8) as i32;
        }
        let mut ans = vec![0; boxes.len()];
        for i in 0..boxes.len() {
            ans[i] = l[i] + r[i];
        }
        ans
    }
}