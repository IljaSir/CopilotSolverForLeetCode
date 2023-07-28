impl Solution {
    pub fn find_min_moves(machines: Vec<i32>) -> i32 {
        
        let sum = machines.iter().sum::<i32>();
        if sum % machines.len() as i32 != 0 {
            return -1;
        }
        let avg = sum / machines.len() as i32;
        let mut left = 0;
        let mut right = sum - machines[0];
        let mut max = 0;
        for i in 0..machines.len() {
            let cur = machines[i];
            let mut need = 0;
            if cur > avg {
                need = cur - avg;
            } else {
                need = avg - cur;
            }
            if i > 0 {
                left += machines[i - 1];
                right -= machines[i];
            }
            if left > right {
                need += left - right;
            } else {
                need += right - left;
            }
            if need > max {
                max = need;
            }
        }
        max
    }
}