impl Solution {
    pub fn max_turbulence_size(arr: Vec<i32>) -> i32 {
        
        let mut ans = 1;
        let mut start = 0;
        let mut end = 0;
        let mut last = 0;
        while end < arr.len() - 1 {
            let a = arr[end];
            let b = arr[end + 1];
            let c = b.cmp(&a);
            if c == last {
                start = end;
            } else if c == std::cmp::Ordering::Equal {
                start = end + 1;
            }
            ans = ans.max(end - start + 2);
            last = c;
            end += 1;
        }
        ans as i32
    }
}