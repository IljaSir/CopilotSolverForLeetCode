impl Solution {
    pub fn maximum_subarray_sum(nums: Vec<i32>, k: i32) -> i64 {
        
        let mut sum = 0;
        let mut max_sum = 0;
        let mut seen = std::collections::HashSet::new();
        let mut window = std::collections::VecDeque::new();
        for i in 0..nums.len() {
            let num = nums[i];
            if !seen.contains(&num) {
                seen.insert(num);
                sum += num;
            }
            window.push_back(num);
            if window.len() > k as usize {
                let out = window.pop_front().unwrap();
                if !window.contains(&out) {
                    seen.remove(&out);
                    sum -= out;
                }
            }
            max_sum = std::cmp::max(max_sum, sum);
        }
        max_sum
    }
}