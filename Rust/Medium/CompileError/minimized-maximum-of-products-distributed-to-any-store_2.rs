impl Solution {
    pub fn minimized_maximum(n: i32, quantities: Vec<i32>) -> i32 {
        
        let n = n as usize;
        let mut quantities = quantities;
        quantities.sort();
        let mut left = 1;
        let mut right = quantities.iter().sum::<i32>() as usize;
        while left < right {
            let mid = (left + right) / 2;
            let mut total = 0;
            for q in quantities.iter().rev() {
                total += (q as usize + mid - 1) / mid;
                if total > n {
                    break;
                }
            }
            if total > n {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        left as i32
    }
}