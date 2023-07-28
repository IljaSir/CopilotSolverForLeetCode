impl Solution {
    pub fn minimized_maximum(n: i32, quantities: Vec<i32>) -> i32 {
        
        let n = n as usize;
        let mut quantities = quantities;
        quantities.sort();
        quantities.reverse();
        let mut left = 1;
        let mut right = quantities[0] as usize;
        while left <= right {
            let mid = (left + right) / 2;
            let mut sum = 0;
            for &q in quantities.iter() {
                sum += q as usize / mid;
                if sum >= n {
                    break;
                }
            }
            if sum >= n {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        left as i32
    }
}