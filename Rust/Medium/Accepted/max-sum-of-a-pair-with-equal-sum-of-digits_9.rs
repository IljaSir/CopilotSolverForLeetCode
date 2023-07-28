impl Solution {
    pub fn maximum_sum(nums: Vec<i32>) -> i32 {
        
        let mut max = -1;
        let mut a = vec![0; 100];
        for &n in nums.iter() {
            let s = n.to_string().chars().map(|c| c.to_digit(10).unwrap() as usize).sum::<usize>();
            if a[s] > 0 {
                max = max.max(a[s] + n);
            }
            a[s] = a[s].max(n);
        }
        max
    }
}